package com.example.lorreneogbonna.shavit.views.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.lorreneogbonna.shavit.Controller.AppController;
import com.example.lorreneogbonna.shavit.R;

public class CadastroActivity extends AppCompatActivity {

    int userType = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final AppController appController = new AppController();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final TextInputEditText inputNome = findViewById(R.id.inputNome);
        final TextInputEditText inputEmail = findViewById(R.id.inputEmail);
        final TextInputEditText inputMorada = findViewById(R.id.inputMorada);
        final TextInputEditText inputTelefone = findViewById(R.id.inputTelefone);
        final TextInputEditText inputNif = findViewById(R.id.inputNif);
        final TextInputEditText inputIdade = findViewById(R.id.inputIdade);
        final TextInputEditText inputPassword = findViewById(R.id.inputPassword);
        final Switch switchUser = (Switch) findViewById(R.id.switchUser);

        Button buttonCadastrar = (Button) findViewById(R.id.cadastrarSend);
        Button buttonCancelar = (Button) findViewById(R.id.cancelarCadastro);

        switchUser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchUser.setText("Clinica");
                    userType = 1;//clinica
                    inputIdade.setVisibility(View.GONE);
                } else {
                    userType = 2;//cliente
                    switchUser.setText("Cliente");
                    inputIdade.setVisibility(View.VISIBLE);
                }
            }
        });


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = inputNome.getText().toString().toLowerCase();
                String email = inputEmail.getText().toString();
                String morada = inputMorada.getText().toString();
                String telefone = inputTelefone.getText().toString();
                String nif = inputNif.getText().toString();
                String password = inputPassword.getText().toString();

                int idUser = 0;
                if(userType==1) {
                    idUser = appController.cadastrarClinica(nome, email, morada, telefone, nif, password);

                    if (idUser != -1) {//success
                        Intent intent = new Intent(CadastroActivity.this, HomeAgendamentoClinicaActivity.class);
                        intent.putExtra("nomeUsuario",nome);
                        intent.putExtra("emailUsuario",email);
                        intent.putExtra("moradalUsuario",morada);
                        intent.putExtra("telefoneUsuario",telefone);
                        intent.putExtra("nifUsuario",nif);
                        intent.putExtra("passwordUsuario",password);
                        startActivity(intent);
                    }
                }
                else{
                    int idade = Integer.parseInt(inputIdade.getText().toString());
                    idUser = appController.cadastrarCliente(nome, email, morada, telefone, nif, idade, password);

                    if(idUser != -1) {//success
                        Intent intent = new Intent(CadastroActivity.this, HomeBuscarClienteActivity.class);
                        intent.putExtra("nomeUsuario",nome);
                        intent.putExtra("emailUsuario",email);
                        intent.putExtra("moradaUsuario",morada);
                        intent.putExtra("telefoneUsuario",telefone);
                        intent.putExtra("nifUsuario",nif);
                        intent.putExtra("idadeUsuario",Integer.parseInt(inputIdade.getText().toString()));

                        startActivity(intent);

                    }

                }


            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}

