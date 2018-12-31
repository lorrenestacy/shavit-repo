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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.DetalhesServicoBuscaActivity;
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

                        Intent editServicoIntent = new Intent(getContext(), DetalhesServicoBuscaActivity.class);
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_NAME_KEY, clickedServico.getNome());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_DESCRIPTION_KEY, clickedServico.getDescricao());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_PRICE_KEY, clickedServico.getPreco());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_BODYREGION_KEY, clickedServico.getAreaCorpo());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_DURATION_KEY, clickedServico.getDuracao());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_CLINICA_LOCAL_KEY, clickedServico.getClinica().getMorada());
                        editServicoIntent.putExtra(DetalhesServicoBuscaActivity.EXTRA_CLINICA_NAME_KEY, clickedServico.getClinica().getNome());
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
            //lista servicos de cada clinica depois


            Clinica clinica = new Clinica( "Clinica 1",  "email1@email",  "rua algo",  "1282378",  "2182918",  "123");
            clinica.getServicos().add(new Servico("Nome Serviço 1", "Descrição serviço 1", 25.5, 2.0, clinica, "axilas"));
            clinica.getServicos().add(new Servico("Nome Serviço 2", "Descrição serviço 2", 15.7, 0.6, clinica, "pes"));

            Clinica clinica2 = new Clinica( "Clinica 2",  "email2@email",  "rua algo2",  "1282378",  "2182918",  "123");
            clinica2.getServicos().add(new Servico("Nome Serviço 1", "Descrição serviço 1", 25.5, 2.0, clinica2, "axilas"));
            clinica2.getServicos().add(new Servico("Nome Serviço 2", "Descrição serviço 2", 15.7, 0.6, clinica2, "virilha"));

            fetchedServicesMock.add(clinica.getServicos().get(0));
            fetchedServicesMock.add(clinica.getServicos().get(1));
            fetchedServicesMock.add(clinica2.getServicos().get(0));
            fetchedServicesMock.add(clinica2.getServicos().get(1));

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
