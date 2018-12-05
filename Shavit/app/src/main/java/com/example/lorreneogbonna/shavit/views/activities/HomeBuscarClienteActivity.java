package com.example.lorreneogbonna.shavit.views.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_buscar_cliente);

        BottomNavigationView navigation = findViewById(R.id.navigation_cliente);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationSelectionItemListener());

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
