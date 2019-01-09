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
import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.apiconsuming.ApiClient;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ServicoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.PedidoApi;
import com.example.lorreneogbonna.shavit.views.activities.PedidoAvaliacaoActivity;
import com.example.lorreneogbonna.shavit.views.activities.PedidoClinicaActivity;
import com.example.lorreneogbonna.shavit.views.adapters.AgendamentosAdapter;
import com.example.lorreneogbonna.shavit.views.adapters.PedidoAdapter;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class PedidosClinicaFragment extends Fragment {
    private static final String EXTRA_SERVICO_NAME_KEY = "agendamentoId";
    private static final String EXTRA_SERVICO_DESCRIPTION_KEY = "agendamentoId";
    private List<Pedido> pedidos;
    private PedidoAdapter pedidosAdapter;
    private RecyclerView listPedidos;
    private View view;

    private PedidoApi pedidoApi;

    public PedidosClinicaFragment() {
        // Required empty public constructor
        pedidos = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pedidos_clinica, container, false);

        pedidoApi = ApiClient.getClient().create(PedidoApi.class);

        //carregar lista
        listPedidos = view.findViewById(R.id.tabsListPedidoClinica);

        pedidosAdapter = new PedidoAdapter(pedidos, new OnClickedItem() {

            @Override
            public void onclick(View view, int position) {

                Pedido clickedServico = pedidos.get(position);

                Intent editServicoIntent = new Intent(getContext(), PedidoAvaliacaoActivity.class);
                startActivity(editServicoIntent);
            }
        });

        //setting up recycler view
        listPedidos.setLayoutManager(new LinearLayoutManager(getContext()));
        listPedidos.setItemAnimator(new DefaultItemAnimator());
        listPedidos.setAdapter(pedidosAdapter);

        new PedidosClinicaFragment.LoadServicos().execute();
        // Inflate the layout for this fragment
        return view;
    }
    public class LoadServicos extends AsyncTask<Void,Void,List<Pedido>> {

        @Override
        protected List<Pedido> doInBackground(Void... voids) {
            Call<List<PedidoDTO>> listPedidoCall = pedidoApi.getListPedidosSolicitados();
            try {
                List<PedidoDTO> apiResult = listPedidoCall.execute().body();
                return convertToEntities(apiResult);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error while trying to fetch Serviços");
            }
        }

        @Override
        protected void onPostExecute(List<Pedido> fetchedPedidos) {

            super.onPostExecute(pedidos);

            int listCurrentSize = pedidos.size();

            pedidos.clear();
            pedidos.addAll(fetchedPedidos);

            //notifying the adapter about the changes on the list
            pedidosAdapter.notifyItemRangeRemoved(0, listCurrentSize);
            pedidosAdapter.notifyItemRangeInserted(0, pedidos.size());

        }
    }

    private List<Pedido> convertToEntities (List<PedidoDTO> dtos) {

        List<Pedido> entities = new ArrayList<>();
        for (PedidoDTO dto : dtos) {
            entities.add(dto.convertToPedido());
        }

        return entities;
    }

}
