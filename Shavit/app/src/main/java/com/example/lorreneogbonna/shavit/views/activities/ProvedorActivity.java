package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.R;

public class ProvedorActivity extends AppCompatActivity {
    public static final String EXTRA_PROVEDOR_NAME_KEY = "nameServicoId";
    public static final String EXTRA_PROVEDOR_DESCRIPTION_KEY = "descriptionServicoId";
    public static final String EXTRA_PROVEDOR_SERVICO_KEY = "servicoProvedorId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provedor);

        //getting components
        EditText txtNomeProvedorText = findViewById(R.id.txtNomeProvedor);
        EditText txtTelefoneProvedorText = findViewById(R.id.txtTelefoneProvedor);
        EditText txtServicoProvedorText = findViewById(R.id.txtServicoProvedor);

        Button btnConfirm = findViewById(R.id.btnAddProvedorEdit);
        Button btnCancel = findViewById(R.id.btnCancelProvedorEdit);

        //getting possible values for intent
        Intent intent = getIntent();
        String nameService = intent.getStringExtra(ProvedorActivity.EXTRA_PROVEDOR_NAME_KEY);
        String descriptionService = intent.getStringExtra(ProvedorActivity.EXTRA_PROVEDOR_DESCRIPTION_KEY);
        String serviceProvedor = intent.getStringExtra(ProvedorActivity.EXTRA_PROVEDOR_SERVICO_KEY);

        txtNomeProvedorText.setText(nameService == null ? "" : nameService);
        txtTelefoneProvedorText.setText(descriptionService == null ? "" : descriptionService);
        txtServicoProvedorText.setText(descriptionService == null ? "" : serviceProvedor);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placeholder operation
                Toast.makeText(ProvedorActivity.this,
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
