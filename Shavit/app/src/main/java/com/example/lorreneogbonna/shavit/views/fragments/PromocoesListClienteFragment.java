package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
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
import android.widget.Button;

import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.Model.Promocao;
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.PromocaoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.PromocaoAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;

public class PromocoesListClienteFragment extends Fragment {
    private static final String EXTRA_SERVICO_NAME_KEY = "agendamentoId";
    private static final String EXTRA_SERVICO_DESCRIPTION_KEY = "agendamentoId";
    private List<Promocao> promocoes;
    private PromocaoAdapter promocaoAdapter;
    private RecyclerView listAgendamentos;
    View view;

    public PromocoesListClienteFragment() {
        promocoes = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_promocao_cliente, container, false);

        Button buscar = view.findViewById(R.id.buscarPromo);

        buscar.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {

                //carregar lista
                listAgendamentos = view.findViewById(R.id.tabsListPromocaoCliente);

                promocaoAdapter = new PromocaoAdapter(promocoes, new OnClickedItem() {

                    @Override
                    public void onclick(View view, int position) {

                        Promocao clickedPromocao = promocoes.get(position);

                        Intent editServicoIntent = new Intent(getContext(), PromocaoActivity.class);

                        editServicoIntent.putExtra(PromocoesListClienteFragment.EXTRA_SERVICO_NAME_KEY, clickedPromocao.getDercricao());
                        editServicoIntent.putExtra(PromocoesListClienteFragment.EXTRA_SERVICO_DESCRIPTION_KEY, clickedPromocao.getPeriodo());
                        editServicoIntent.putExtra(PromocoesListClienteFragment.EXTRA_SERVICO_DESCRIPTION_KEY, clickedPromocao.getPreco());

                        startActivity(editServicoIntent);
                    }
                });

                //setting up recycler view
                listAgendamentos.setLayoutManager(new LinearLayoutManager(getContext()));
                listAgendamentos.setItemAnimator(new DefaultItemAnimator());
                listAgendamentos.setAdapter(promocaoAdapter);

                new PromocoesListClienteFragment.LoadServicos().execute();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public class LoadServicos extends AsyncTask<Void,Void,List<Promocao>> {

        @Override
        protected List<Promocao> doInBackground(Void... voids) {
            Clinica clinica = new Clinica("minha stetic", "stetic@gmail.com", "rua de la", "738273283", "7832782", "123");
            Servico servico = new Servico("Nome Serviço 1", "Descrição serviço 1", 25.5, 2.0, clinica , "axilas");

            //TODO remove this when we get the database working
            List<Promocao> fetchedPromocaoMock = new ArrayList<>();
            fetchedPromocaoMock.add(new Promocao(clinica, servico, "5,00","barato", "ate amanha"));
            fetchedPromocaoMock.add(new Promocao(clinica, servico, "5,00","barato", "ate amanha"));
            fetchedPromocaoMock.add(new Promocao(clinica, servico, "5,00","barato", "ate amanha"));
            fetchedPromocaoMock.add(new Promocao(clinica, servico, "5,00","barato", "ate amanha"));

            return fetchedPromocaoMock;
        }

        @Override
        protected void onPostExecute(List<Promocao> fetchedAgendamentos) {

            super.onPostExecute(promocoes);

            int listCurrentSize = promocoes.size();

            promocoes.clear();
            promocoes.addAll(fetchedAgendamentos);

            //notifying the adapter about the changes on the list
            promocaoAdapter.notifyItemRangeRemoved(0, listCurrentSize);
            promocaoAdapter.notifyItemRangeInserted(0, promocoes.size());

        }
    }
}
