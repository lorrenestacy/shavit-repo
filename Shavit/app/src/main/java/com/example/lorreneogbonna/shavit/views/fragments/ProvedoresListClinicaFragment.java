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
import com.example.lorreneogbonna.shavit.views.activities.ProvedorActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ProvedoresAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;

public class ProvedoresListClinicaFragment extends Fragment {

    private List<Provedor> provedores;
    private ProvedoresAdapter provedoresAdapter;
    private RecyclerView rvListProvedores;

    public ProvedoresListClinicaFragment() {
        provedores = new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provedores_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton btnAddServico = getView().findViewById(R.id.btnAddProvedor);
        btnAddServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToNewServico = new Intent(getContext(),ProvedorActivity.class);
                startActivity(intentToNewServico);
            }
        });

        rvListProvedores = getView().findViewById(R.id.listProvedores);

        provedoresAdapter = new ProvedoresAdapter(provedores, new OnClickedItem() {
            @Override
            public void onclick(View view, int position) {
                Provedor clickedProvedor = provedores.get(position);

                Intent editProvedorIntent = new Intent(getContext(), ProvedorActivity.class);
                editProvedorIntent.putExtra(ProvedorActivity.EXTRA_PROVEDOR_NAME_KEY, clickedProvedor.getNome());
                editProvedorIntent.putExtra(ProvedorActivity.EXTRA_PROVEDOR_DESCRIPTION_KEY, clickedProvedor.getTelefone());

                startActivity(editProvedorIntent);

//                Toast.makeText(getActivity(), clickedProvedor.getNome() , Toast.LENGTH_SHORT).show();
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

            //TODO remove this when we get the database working
            List<Provedor> fetchedProvedoresMock = new ArrayList<>();
            fetchedProvedoresMock.add(new Provedor("Provedor 1", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 2", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 3", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 4", "+XXX YY ZZZ ZZZZ"));

            return fetchedProvedoresMock;
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
}
