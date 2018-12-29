package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.ServicoActivity;
import com.example.lorreneogbonna.shavit.views.adapters.ServicosAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.ArrayList;
import java.util.List;


public class BuscaClienteFragment extends Fragment {

    private List<Servico> servicos;
    private ServicosAdapter servicosAdapter;
    private RecyclerView listServicos;
    View view;

    public BuscaClienteFragment() {
        servicos = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_busca_cliente, container, false);

        RadioButton buscaComum, dataHoraBusca;
        final RadioGroup radioGroupBusca = view.findViewById(R.id.radioGroupBusca);
        buscaComum = (RadioButton) view.findViewById(R.id.comumBusca);
        dataHoraBusca = (RadioButton) view.findViewById(R.id.dataHoraBusca);
        Button buscar = view.findViewById(R.id.buttonBuscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
                final TextInputEditText inputBuscaServicoHome = view.findViewById(R.id.inputBuscaServicoHome);
                String valorBusca = inputBuscaServicoHome.getText().toString();

                int selectedId=radioGroupBusca.getCheckedRadioButtonId();
                int tipoBusca=0;
                if(selectedId==R.id.comumBusca)tipoBusca=1;
                else if(selectedId==R.id.dataHoraBusca)tipoBusca=2;

                //carregar lista
                listServicos = view.findViewById(R.id.listServicosBusca);

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

                new BuscaClienteFragment.LoadServicos().execute();

            }
        });
        // Inflate the layout for this fragment
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
