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
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.ServicoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ServicosAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;


public class AgendamentosClienteFragment extends Fragment {
    private static final String EXTRA_SERVICO_NAME_KEY = "";
    private List<Agendamento> agendamentos;
    private ServicosAdapter servicosAdapter;
    private RecyclerView listAgendamentos;
    View view;
    public AgendamentosClienteFragment() {
        agendamentos = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agendamentos_cliente, container, false);
        // Inflate the layout for this fragment


        //carregar lista
        listAgendamentos = view.findViewById(R.id.tabsListAgendamentosCliente);

        servicosAdapter = new ServicosAdapter(agendamentos, new OnClickedItem() {

            @Override
            public void onclick(View view, int position) {

                Agendamento clickedAgendamento = agendamentos.get(position);

                Intent editServicoIntent = new Intent(getContext(), ServicoActivity.class);
                editServicoIntent.putExtra(AgendamentosClienteFragment.EXTRA_SERVICO_NAME_KEY, clickedAgendamento.getData());
                editServicoIntent.putExtra(ServicoActivity.EXTRA_SERVICO_DESCRIPTION_KEY, clickedAgendamento.getHorario());

                startActivity(editServicoIntent);
            }
        });

        //setting up recycler view
        listServicos.setLayoutManager(new LinearLayoutManager(getContext()));
        listServicos.setItemAnimator(new DefaultItemAnimator());
        listServicos.setAdapter(servicosAdapter);

        new AgendamentosClienteFragment.LoadServicos().execute();


        return view;
    }

    public class LoadServicos extends AsyncTask<Void,Void,List<Servico>> {

        @Override
        protected List<Servico> doInBackground(Void... voids) {

            //TODO remove this when we get the database working
            List<Servico> fetchedServicesMock = new ArrayList<>();
            fetchedServicesMock.add(new Servico("Nome Serviço 1", "Descrição serviço 1"));
            fetchedServicesMock.add(new Servico("Nome Serviço 2", "Descrição serviço 2"));
            fetchedServicesMock.add(new Servico("Nome Serviço 3", "Descrição serviço 3"));
            fetchedServicesMock.add(new Servico("Nome Serviço 4", "Descrição serviço 4"));

            return fetchedServicesMock;
        }

        @Override
        protected void onPostExecute(List<Servico> fetchedServicos) {

            super.onPostExecute(servicos);

            int listCurrentSize = servicos.size();

            servicos.clear();
            servicos.addAll(fetchedServicos);

            //notifying the adapter about the changes on the list
            servicosAdapter.notifyItemRangeRemoved(0, listCurrentSize);
            servicosAdapter.notifyItemRangeInserted(0, servicos.size());

        }
    }
}
