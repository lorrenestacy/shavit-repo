package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.ServicoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ServicosAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;

public class ServicosListFragment extends Fragment {

    private List<Servico> servicos;
    private ServicosAdapter servicosAdapter;
    private RecyclerView listServicos;

    public ServicosListFragment() {
        servicos = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servicos_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton btnAddServico = getView().findViewById(R.id.btnAddServico);
        btnAddServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToNewServico = new Intent(getContext(),ServicoActivity.class);
                startActivity(intentToNewServico);
            }
        });

        listServicos = getView().findViewById(R.id.listServicos);

        servicosAdapter = new ServicosAdapter(servicos, new OnClickedItem() {

            @Override
            public void onclick(View view, int position) {

                Servico clickedServico = servicos.get(position);

                Intent editServicoIntent = new Intent(getContext(), ServicoActivity.class);
                editServicoIntent.putExtra(ServicoActivity.EXTRA_SERVICO_NAME_KEY, clickedServico.getNome());
                editServicoIntent.putExtra(ServicoActivity.EXTRA_SERVICO_DESCRIPTION_KEY, clickedServico.getDescricao());

                startActivity(editServicoIntent);
            }
        });

        //setting up recycler view
        listServicos.setLayoutManager(new LinearLayoutManager(getContext()));
        listServicos.setItemAnimator(new DefaultItemAnimator());
        listServicos.setAdapter(servicosAdapter);

        new LoadServicos().execute();
    }

    protected class LoadServicos extends AsyncTask<Void,Void,List<Servico>> {

        @Override
        protected List<Servico> doInBackground(Void... voids) {

            //TODO remove this when we get the database working
            List<Servico> fetchedServicesMock = new ArrayList<>();
            Clinica clinica = new Clinica( "Clinica 1",  "email1@email",  "rua algo",  "1282378",  "2182918",  "123");
            fetchedServicesMock.add(new Servico("Nome Serviço 1", "Descrição serviço 1", 18.5, 1.5, clinica, "virilha"));
            fetchedServicesMock.add(new Servico("Nome Serviço 2", "Descrição serviço 2", 15.7, 0.6, clinica, "buco"));
            fetchedServicesMock.add(new Servico("Nome Serviço 3", "Descrição serviço 3", 35.6, 2.5, clinica, "coxa"));
            fetchedServicesMock.add(new Servico("Nome Serviço 4", "Descrição serviço 4", 25.9, 1.5, clinica, "costas"));

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
