package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.apiconsuming.ApiClient;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoAgendamentoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoSimplesDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ProvedorDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.PedidoApi;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.ProvedorApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidoAvaliacaoActivity extends AppCompatActivity {

    private Spinner spinnerProvedores;
    public static final String PEDIDO_KEY = "pedidoKeyObject";

    private Pedido pedido;
    private ProvedorApi provedorApi;
    private PedidoApi pedidoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_avaliacao);

        provedorApi = ApiClient.getClient().create(ProvedorApi.class);
        pedidoApi = ApiClient.getClient().create(PedidoApi.class);

        Intent intent = getIntent();
        pedido = (Pedido) intent.getSerializableExtra(PEDIDO_KEY);

        TextInputEditText txtNameCliente = findViewById(R.id.activityPedidoAvaliacao_txtNomeCliente);
        txtNameCliente.setText(pedido.getCliente().getNome());

        TextInputEditText txtData = findViewById(R.id.activityPedidoAvaliacao_txtData);
        txtData.setText(pedido.getData());

        TextInputEditText txtHorario = findViewById(R.id.activityPedidoAvaliacao_txtHorario);
        txtHorario.setText(pedido.getHorario());

        TextInputEditText txtServicoName = findViewById(R.id.activityPedidoAvaliacao_txtServico);
        txtServicoName.setText(pedido.getServico().getNome());

        Button btnAgendar = findViewById(R.id.activityPedidoAvaliacao_btnAceitarPedido);
        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Provedor provedorSelecionado = (Provedor) spinnerProvedores.getSelectedItem();
                if (provedorSelecionado == null)
                    return; //not yet loaded

                PedidoAgendamentoDTO pedidoAgendamentoDTO = new PedidoAgendamentoDTO(pedido.getId(),
                        provedorSelecionado.getId());

                Call<ResponseBody> callAgendamento = pedidoApi.agendarPedido(pedidoAgendamentoDTO);
                callAgendamento.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(PedidoAvaliacaoActivity.this,
                                "Agendamento marcado com sucesso",
                                Toast.LENGTH_SHORT)
                                .show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(PedidoAvaliacaoActivity.this,
                                "Erro enquanto tentando criar agendamento",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

        Button btnRecusar = findViewById(R.id.activityPedidoAvaliacao_btnDeclinePedido);
        btnRecusar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PedidoSimplesDTO pedidoSimplesDTO = new PedidoSimplesDTO(pedido.getId());
                Call<ResponseBody> callAgendamento = pedidoApi.recusarPedido(pedidoSimplesDTO);
                callAgendamento.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(PedidoAvaliacaoActivity.this,
                                "Agendamento recusado com sucesso",
                                Toast.LENGTH_SHORT)
                                .show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(PedidoAvaliacaoActivity.this,
                                "Erro enquanto tentando recusar pedido",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

        spinnerProvedores = findViewById(R.id.activityPedidoAvaliacao_spinnerProvedor);
        new LoadProvedores().execute();
    }

    private class LoadProvedores extends AsyncTask <Void,Void,List<Provedor>> {

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
        protected void onPostExecute(List<Provedor> provedores) {
            super.onPostExecute(provedores);
            setupSpinnerWithProvedores(provedores);
        }
    }

    private void setupSpinnerWithProvedores (List<Provedor> provedores) {
        ArrayAdapter provedoresAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, provedores);
        spinnerProvedores.setAdapter(provedoresAdapter);
    }

    private List<Provedor> convertToEntities (List<ProvedorDTO> dtos) {
        List<Provedor> entities = new ArrayList<>();
        for (ProvedorDTO dto : dtos) {
            entities.add(dto.convertToEntity());
        }

        return entities;
    }

}
