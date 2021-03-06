package com.example.lorreneogbonna.shavit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServicoActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICO_NAME_KEY = "nameServicoId";
    public static final String EXTRA_SERVICO_DESCRIPTION_KEY = "descriptionServicoId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        //getting components
        EditText txtServicoNameText = findViewById(R.id.txtNomeServico);
        EditText txtServicoDescriptionText = findViewById(R.id.txtDescricaoServico);
        Button btnConfirm = findViewById(R.id.btnAddServicoEdit);
        Button btnCancel = findViewById(R.id.btnCancelServicoEdit);

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

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
