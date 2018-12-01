package com.example.lorreneogbonna.shavit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_agendamentos:
                    mTextMessage.setText("Agendamentos");
                    return true;
                case R.id.navigation_pedidos:
                    mTextMessage.setText("Pedidos");
                    return true;
                case R.id.navigation_perfil:
                    mTextMessage.setText("Perfil");
                    return true;
                case R.id.navigation_servicos:
                    mTextMessage.setText("Serviços");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_cliente_main);
        getActionBar().hide();

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText("yu");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //buttons
        Button buttonCadastrar = (Button) findViewById(R.id.button_cadastrar);
        Button buttonLogar = (Button) findViewById(R.id.button_logar);
        //end buttons

        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
