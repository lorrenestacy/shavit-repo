package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.apiconsuming.ApiClient;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoSimplesDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.interfaces.PedidoApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendamentoActivity extends AppCompatActivity {

    private Agendamento agendamento;
    public static final String AGENDAMENTO_KEY = "agendamento";

    private PedidoApi pedidoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        pedidoApi = ApiClient.getClient().create(PedidoApi.class);

        Intent intent = getIntent();
        agendamento = (Agendamento) intent.getSerializableExtra(AGENDAMENTO_KEY);

        TextInputEditText txtNomeCliente = findViewById(R.id.activityAgendamento_txtCliente);
        txtNomeCliente.setText(agendamento.getPedido().getCliente().getNome());

        TextInputEditText txtProvedor = findViewById(R.id.activityAgendamento_txtProvedor);
        txtProvedor.setText(agendamento.getProvedor().getNome());

        TextInputEditText txtData = findViewById(R.id.activityAgendamento_txtData);
        txtData.setText(agendamento.getPedido().getData());

        TextInputEditText txtHorario = findViewById(R.id.activityAgendamento_txtHorario);
        txtHorario.setText(agendamento.getPedido().getHorario());

        TextInputEditText txtServico = findViewById(R.id.activityAgendamento_txtServico);
        txtServico.setText(agendamento.getPedido().getServico().getNome());

        Button realizar = findViewById(R.id.activityAgendamento_realizado);
        realizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PedidoSimplesDTO pedidoSimplesDTO = new PedidoSimplesDTO(agendamento.getPedido().getId());
                Call<ResponseBody> callAgendamento = pedidoApi.realizarPedido(pedidoSimplesDTO);
                callAgendamento.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(AgendamentoActivity.this,
                                "Agendamento marcado como realizado com sucesso",
                                Toast.LENGTH_SHORT)
                                .show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(AgendamentoActivity.this,
                                "Erro enquanto tentando marcar como realizado pedido",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

        Button cancelar = findViewById(R.id.activityAgendamento_btnCancelarAgendamentoClinica);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PedidoSimplesDTO pedidoSimplesDTO = new PedidoSimplesDTO(agendamento.getPedido().getId());
                Call<ResponseBody> callAgendamento = pedidoApi.cancelarPedido(pedidoSimplesDTO);
                callAgendamento.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(AgendamentoActivity.this,
                                "Agendamento cancelado com sucesso",
                                Toast.LENGTH_SHORT)
                                .show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(AgendamentoActivity.this,
                                "Erro enquanto tentando cancelar agendamento",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

    }

}
