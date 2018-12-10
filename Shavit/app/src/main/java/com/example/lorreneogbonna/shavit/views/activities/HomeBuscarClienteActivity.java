package com.example.lorreneogbonna.shavit.views.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.fragments.AgendamentosClienteFragment;
import com.example.lorreneogbonna.shavit.views.fragments.BuscaClienteFragment;
import com.example.lorreneogbonna.shavit.views.fragments.PerfilClienteFragment;
import com.example.lorreneogbonna.shavit.views.fragments.PromocoesListClienteFragment;

public class HomeBuscarClienteActivity extends AppCompatActivity {

    private Fragment fragmentBusca = new BuscaClienteFragment();
    private Fragment fragmentAgendamentos = new AgendamentosClienteFragment();
    private Fragment fragmentPromocoes = new PromocoesListClienteFragment();
    private Fragment fragmentPerfil = new PerfilClienteFragment();
    int idadeUsuario;
    String nomeUsuario, moradaUsuario, emailUsuario, telefoneUsuario, nifUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_buscar_cliente);

        BottomNavigationView navigation = findViewById(R.id.navigation_cliente);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationSelectionItemListener());

        Bundle extras = getIntent().getExtras();
        nomeUsuario = extras.getString("nomeUsuario");
        moradaUsuario = extras.getString("moradaUsuario");
        emailUsuario = extras.getString("emailUsuario");
        telefoneUsuario = extras.getString("telefoneUsuario");
        nifUsuario = extras.getString("nifUsuario");
        idadeUsuario = extras.getInt("idadeUsuario");

        TextView bemVindoUsuario = findViewById(R.id.bemVindoUsuarioCliente);

        String s1 = nomeUsuario.substring(0, 1).toUpperCase();
        String nameCapitalized = s1 + nomeUsuario.substring(1);

        bemVindoUsuario.setText(bemVindoUsuario.getText()+nameCapitalized+"!   Explore por aí");
        //loading initial fragment
        loadFragment(fragmentBusca);
    }

    private class BottomNavigationSelectionItemListener implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_busca:
                    loadFragment(fragmentBusca);
                    return true;

                case R.id.navigation_agendamentos_cliente:
                    loadFragment(fragmentAgendamentos);
                    return true;

                case R.id.navigation_promocoes_cliente:
                    loadFragment(fragmentPromocoes);
                    return true;

                case R.id.navigation_perfil_cliente:
                    Bundle bundle = new Bundle();
                    bundle.putInt("idadeUsuario", idadeUsuario);
                    bundle.putString("nomeUsuario", nomeUsuario);
                    bundle.putString("moradaUsuario", moradaUsuario);
                    bundle.putString("emailUsuario", emailUsuario);
                    bundle.putString("telefoneUsuario", telefoneUsuario);
                    bundle.putString("nifUsuario", nifUsuario);

                    fragmentPerfil.setArguments(bundle);
                    loadFragment(fragmentPerfil);
                    return true;
            }

            return false;
        }
    }

    /**
     * Loading fragment passed as parameters into the frame layout set for the current activity
     * */
    private void loadFragment (Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.homeClienteFragmentContent, fragment)
                .addToBackStack("Home")
                .commit();
    }
}
