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

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.apiconsuming.ApiClient;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ServicoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.ServicoApi;
import com.example.lorreneogbonna.shavit.views.activities.ServicoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ServicosAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ServicosListFragment extends Fragment {

    private List<Servico> servicos;
    private ServicosAdapter servicosAdapter;
    private RecyclerView listServicos;

    private ServicoApi servicoApi;

    public ServicosListFragment() {
        servicos = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        servicoApi = ApiClient.getClient().create(ServicoApi.class);

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

                Bundle extras = new Bundle();
                extras.putSerializable(ServicoActivity.EXTRA_SERVICO_KEY, clickedServico);

                Intent editServicoIntent = new Intent(getContext(), ServicoActivity.class);
                editServicoIntent.putExtras(extras);
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

            Call<List<ServicoDTO>> listServicoCall = servicoApi.getListServicos();
            try {
                List<ServicoDTO> apiResult = listServicoCall.execute().body();
                return convertToEntities(apiResult);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error while trying to fetch Serviços");
            }
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

    private List<Servico> convertToEntities (List<ServicoDTO> dtos) {

        List<Servico> entities = new ArrayList<>();
        for (ServicoDTO dto : dtos) {
            entities.add(dto.convertToEntity());
        }

        return entities;
    }

}
