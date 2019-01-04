package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.R;

public class ServicoActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICO_NAME_KEY = "nameServicoId";
    public static final String EXTRA_SERVICO_DESCRIPTION_KEY = "descriptionServicoId";
    public static final String EXTRA_SERVICO_PRICE_KEY = "priceServicoId";
    public static final String EXTRA_SERVICO_DURATION_KEY = "durationServicoId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        //getting components
        EditText txtServicoNameText = findViewById(R.id.txtNomeServico);
        EditText txtServicoDescriptionText = findViewById(R.id.txtDescricaoServico);
        Button btnConfirm = findViewById(R.id.btnAddServicoEdit);

        //getting possible values for intent
        Intent intent = getIntent();
        String nameService = intent.getStringExtra(ServicoActivity.EXTRA_SERVICO_NAME_KEY);
        String descriptionService = intent.getStringExtra(ServicoActivity.EXTRA_SERVICO_DESCRIPTION_KEY);

        txtServicoNameText.setText(nameService == null ? "" : nameService);
        txtServicoDescriptionText.setText(descriptionService == null ? "" : descriptionService);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placeholder operation
                Toast.makeText(ServicoActivity.this,
                        "Operação realizada com sucesso",
                        Toast.LENGTH_SHORT).show();

                //just going back to parent activity
                finish();
            }
        });

    }

}
