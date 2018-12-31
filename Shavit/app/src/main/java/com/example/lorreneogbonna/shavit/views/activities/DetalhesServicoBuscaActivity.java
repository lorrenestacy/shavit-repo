package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.R;

public class DetalhesServicoBuscaActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICO_NAME_KEY = "nameServicoId";
    public static final String EXTRA_SERVICO_DESCRIPTION_KEY = "descriptionServicoId";
    public static final String EXTRA_SERVICO_PRICE_KEY = "priceServicoId";
    public static final String EXTRA_SERVICO_DURATION_KEY = "durationServicoId";
    public static final String EXTRA_CLINICA_LOCAL_KEY = "clinicLocationId";
    public static final String EXTRA_CLINICA_NAME_KEY ="clinicNameId" ;
    public static final String EXTRA_SERVICO_BODYREGION_KEY ="bodyRegionId" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_servico_busca);

        TextView nomeClinica = findViewById(R.id.nomeClinicaDetalheServico);
        TextView localClinica = findViewById(R.id.localClinicaDetalheServico);
        TextView nomeServico = findViewById(R.id.nomeDetalheServico);
        TextView descricaoServico = findViewById(R.id.descricaoDetalheServico);
        TextView areaCorpo = findViewById(R.id.areaCorpoDetalheServico);
        TextView priceServico = findViewById(R.id.priceDetalheServico);
        TextView duracaoServico = findViewById(R.id.duracaoServico);

        Intent intent = getIntent();
        nomeServico.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_NAME_KEY));
        descricaoServico.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_DESCRIPTION_KEY));
        areaCorpo.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_BODYREGION_KEY));
        duracaoServico.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_DURATION_KEY));
        priceServico.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_SERVICO_PRICE_KEY));
        nomeClinica.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_CLINICA_NAME_KEY));
        localClinica.setText(intent.getStringExtra(DetalhesServicoBuscaActivity.EXTRA_CLINICA_LOCAL_KEY));


        (findViewById(R.id.verificarDisponibilidadeServicoBusca)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placeholder operation
                Toast.makeText(DetalhesServicoBuscaActivity.this,
                        "Operação realizada com sucesso",
                        Toast.LENGTH_SHORT).show();

                //just going back to parent activity
                finish();
            }
        });

        (findViewById(R.id.voltarDetalheServicoBusca)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
