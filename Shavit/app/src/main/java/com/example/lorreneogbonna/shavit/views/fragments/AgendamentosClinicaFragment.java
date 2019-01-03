package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.AgendamentoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.AgendamentosAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;

public class AgendamentosClinicaFragment extends Fragment {
    private static final String EXTRA_SERVICO_NAME_KEY = "agendamentoId";
    private static final String EXTRA_SERVICO_DESCRIPTION_KEY = "agendamentoId";
    private List<Agendamento> agendamentos;
    private AgendamentosAdapter agendamentosAdapter;
    private RecyclerView listAgendamentos;
    View view;

    public AgendamentosClinicaFragment() {
        agendamentos = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agendamentos_clinica, container, false);
        // Inflate the layout for this fragment

        //carregar lista
        listAgendamentos = view.findViewById(R.id.tabsListAgendamentosClinica);

        agendamentosAdapter = new AgendamentosAdapter(agendamentos, new OnClickedItem() {

            @Override
            public void onclick(View view, int position) {

                Agendamento clickedAgendamento = agendamentos.get(position);

                Intent editServicoIntent = new Intent(getContext(), AgendamentoActivity.class);

                editServicoIntent.putExtra(AgendamentosClinicaFragment.EXTRA_SERVICO_NAME_KEY,
                        clickedAgendamento.getPedido().getData());
                editServicoIntent.putExtra(AgendamentosClinicaFragment.EXTRA_SERVICO_DESCRIPTION_KEY,
                        clickedAgendamento.getPedido().getHorario());

                startActivity(editServicoIntent);
            }
        });

        //setting up recycler view
        listAgendamentos.setLayoutManager(new LinearLayoutManager(getContext()));
        listAgendamentos.setItemAnimator(new DefaultItemAnimator());
        listAgendamentos.setAdapter(agendamentosAdapter);

        new AgendamentosClinicaFragment.LoadServicos().execute();

        return view;
    }

    public class LoadServicos extends AsyncTask<Void,Void,List<Agendamento>> {

        @Override
        protected List<Agendamento> doInBackground(Void... voids) {
            Cliente cliente = new Cliente("lo", "lo@com.pt", 20, "rua de la", "36762789", "38237827", "123");
            Clinica clinica = new Clinica("minha stetic", "stetic@gmail.com", "rua de la", "738273283", "7832782", "123");
            Servico servico = new Servico("Nome Serviço 2", "Descrição serviço 2", 15.7, 0.6, clinica, "virilha");
            //pegar a referencia da propria clinica dps

            //TODO remove this when we get the database working
            List<Agendamento> fetchedAgendamentosMock = new ArrayList<>();
            fetchedAgendamentosMock.add(new Agendamento(cliente, clinica, "00:00", "10/10/10", servico));
            fetchedAgendamentosMock.add(new Agendamento(cliente, clinica, "00:00", "10/10/10", servico));
            fetchedAgendamentosMock.add(new Agendamento(cliente, clinica, "00:00", "10/10/10", servico));
            fetchedAgendamentosMock.add(new Agendamento(cliente, clinica, "00:00", "10/10/10", servico));

            return fetchedAgendamentosMock;
        }

        @Override
        protected void onPostExecute(List<Agendamento> fetchedAgendamentos) {

            super.onPostExecute(agendamentos);

            int listCurrentSize = agendamentos.size();

            agendamentos.clear();
            agendamentos.addAll(fetchedAgendamentos);

            //notifying the adapter about the changes on the list
            agendamentosAdapter.notifyItemRangeRemoved(0, listCurrentSize);
            agendamentosAdapter.notifyItemRangeInserted(0, agendamentos.size());

        }
    }

}
