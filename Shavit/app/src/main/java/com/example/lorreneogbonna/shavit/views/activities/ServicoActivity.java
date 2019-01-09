package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;

public class ServicoActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICO_KEY = "servicoKeyExtra";
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
        Servico servico = (Servico) intent.getSerializableExtra(EXTRA_SERVICO_KEY);

        txtServicoNameText.setText(servico.getNome() == null ? "" : servico.getNome());
        txtServicoDescriptionText.setText(servico.getDescricao() == null ? "" : servico.getDescricao());

        //set all fields

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
