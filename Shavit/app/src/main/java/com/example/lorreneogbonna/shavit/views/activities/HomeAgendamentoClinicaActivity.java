package com.example.lorreneogbonna.shavit.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.lorreneogbonna.shavit.views.fragments.PerfilClinicaFragment;
import com.example.lorreneogbonna.shavit.views.fragments.AgendamentosClinicaFragment;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.fragments.PedidosClinicaFragment;
import com.example.lorreneogbonna.shavit.views.fragments.ServicosFragment;

public class HomeAgendamentoClinicaActivity extends AppCompatActivity {

    private Fragment fragmentAgendamentos = new AgendamentosClinicaFragment();
    private Fragment fragmentPedidos = new PedidosClinicaFragment();
    private Fragment fragmentServicos = new ServicosFragment();
    private Fragment fragmentPefil = new PerfilClinicaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_agendamentos_clinica);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationSelectionItemListener());

        //loading initial fragment
        loadFragment(fragmentAgendamentos);
    }

    private class BottomNavigationSelectionItemListener implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_agendamentos:
                    loadFragment(fragmentAgendamentos);
                    return true;

                case R.id.navigation_pedidos:
                    loadFragment(fragmentPedidos);
                    return true;

                case R.id.navigation_servicos:
                    loadFragment(fragmentServicos);
                    return true;

                case R.id.navigation_perfil:
                    loadFragment(fragmentPefil);
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
                        .replace(R.id.homeFragmentContent, fragment)
                        .addToBackStack("Home")
                        .commit();
    }

}
