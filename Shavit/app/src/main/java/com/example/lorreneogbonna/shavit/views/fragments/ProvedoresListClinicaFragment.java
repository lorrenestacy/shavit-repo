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
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.apiconsuming.ApiClient;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ProvedorDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ServicoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.ProvedorApi;
import com.example.lorreneogbonna.shavit.views.activities.ServicoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ProvedoresAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ProvedoresListClinicaFragment extends Fragment {

    private List<Provedor> provedores;
    private ProvedoresAdapter provedoresAdapter;
    private RecyclerView rvListProvedores;

    private ProvedorApi provedorApi;

    public ProvedoresListClinicaFragment() {
        provedores = new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        provedorApi = ApiClient.getClient().create(ProvedorApi.class);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provedores_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton btnAddProvedor = getView().findViewById(R.id.btnAddProvedor);
        btnAddProvedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Adicionando novo provedor...", Toast.LENGTH_SHORT).show();
            }
        });

        rvListProvedores = getView().findViewById(R.id.listProvedores);

        provedoresAdapter = new ProvedoresAdapter(provedores, new OnClickedItem() {
            @Override
            public void onclick(View view, int position) {
                Provedor clickedProvedor = provedores.get(position);
                Toast.makeText(getActivity(), clickedProvedor.getNome() , Toast.LENGTH_SHORT).show();
            }
        });

        //recycler view setup
        rvListProvedores.setLayoutManager(new LinearLayoutManager(getContext()));
        rvListProvedores.setItemAnimator(new DefaultItemAnimator());
        rvListProvedores.setAdapter(provedoresAdapter);

        new LoadProvedores().execute();
    }

    private class LoadProvedores extends AsyncTask<Void,Void,List<Provedor>> {

        @Override
        protected List<Provedor> doInBackground(Void... voids) {

            Call<List<ProvedorDTO>> listServicoCall = provedorApi.listProvedores();
            try {
                List<ProvedorDTO> apiResult = listServicoCall.execute().body();
                return convertToEntities(apiResult);

            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>(); //error; returning empty array
            }
        }

        @Override
        protected void onPostExecute(List<Provedor> fetchedProvedores) {

            super.onPostExecute(fetchedProvedores);

            int listCurrentSize = provedores.size();

            provedores.clear();
            provedores.addAll(fetchedProvedores);

            //notifying the adapter about the changes on the list
            provedoresAdapter.notifyItemRangeRemoved(0, listCurrentSize);
            provedoresAdapter.notifyItemRangeInserted(0, provedores.size());

        }
    }

    private List<Provedor> convertToEntities (List<ProvedorDTO> dtos) {
        List<Provedor> entities = new ArrayList<>();
        for (ProvedorDTO dto : dtos) {
            entities.add(dto.convertToEntity());
        }

        return entities;
    }
}
