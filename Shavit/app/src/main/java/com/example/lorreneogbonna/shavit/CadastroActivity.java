package com.example.lorreneogbonna.shavit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button buttonCadastrar = (Button) findViewById(R.id.cadastrarSend);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
                Intent intent = new Intent(CadastroActivity.this, HomeAgendamentoClienteActivity.class);
                startActivity(intent);
            }
        });
    }

    public void cadastrar(){

    }
}
