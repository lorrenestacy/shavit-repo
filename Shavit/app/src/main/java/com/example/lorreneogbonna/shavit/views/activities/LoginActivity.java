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

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    int userType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        //buttons
        Button buttonCadastrar = (Button) findViewById(R.id.button_cadastrar);
        Button buttonLogar = (Button) findViewById(R.id.button_logar);
        //end buttons

        final AppController appController = new AppController();
        appController.cadastrarCliente("emilia","emilia@pt.com","rua dali","351973287328","492871872", 20, "123");
        appController.cadastrarClinica("stetic","stetic@pt.com","rua dali","351973287328","492871872", "123");


        final TextInputEditText inputUser = findViewById(R.id.input_usuario_login);
        final TextInputEditText inputPassword = findViewById(R.id.input_pass_login);
        final Switch switchUser = (Switch) findViewById(R.id.switchUserLogin);

        switchUser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchUser.setText("Clinica");
                    userType = 1;//clinica
                } else {
                    userType = 2;//cliente
                    switchUser.setText("Cliente");
                }
            }
        });

        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = inputUser.getText().toString();
                String pass = inputPassword.getText().toString();
                int idUser = appController.login(user, pass, userType); //user eh o nome do usuario
                if(idUser != -1){//success
                    if(userType==1){//clinica
                        Intent intent = new Intent(LoginActivity.this, HomeAgendamentoClinicaActivity.class);
                        intent.putExtra("nomeUsuario",user);
                        intent.putExtra("idUsuario",idUser);
                        startActivity(intent);
                    }
                    else {//cliente
                        Intent intent = new Intent(LoginActivity.this, HomeBuscarClienteActivity.class);
                        intent.putExtra("nomeUsuario",user);
                        intent.putExtra("idUsuario",idUser);
                        startActivity(intent);

                    }
                }
            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

}


