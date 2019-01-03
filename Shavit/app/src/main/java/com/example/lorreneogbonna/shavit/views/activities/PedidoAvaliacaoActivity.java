package com.example.lorreneogbonna.shavit.views.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.R;

import java.util.ArrayList;
import java.util.List;

public class PedidoAvaliacaoActivity extends AppCompatActivity {

    private Spinner spinnerProvedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_avaliacao);

        spinnerProvedores = findViewById(R.id.activityPedidoAvaliacao_spinnerProvedor);
        new LoadProvedores().execute();
    }

    private class LoadProvedores extends AsyncTask <Void,Void,List<Provedor>> {

        @Override
        protected List<Provedor> doInBackground(Void... voids) {

            List<Provedor> fetchedProvedoresMock = new ArrayList<>();
            fetchedProvedoresMock.add(new Provedor("Provedor 1", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 2", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 3", "+XXX YY ZZZ ZZZZ"));
            fetchedProvedoresMock.add(new Provedor("Provedor 4", "+XXX YY ZZZ ZZZZ"));

            return fetchedProvedoresMock;
        }

        @Override
        protected void onPostExecute(List<Provedor> provedores) {
            super.onPostExecute(provedores);
            setupSpinnerWithProvedores(provedores);
        }
    }

    private void setupSpinnerWithProvedores (List<Provedor> provedores) {

        ArrayAdapter provedoresAdapter = new ArrayAdapter(this, R.layout.spinner_item, provedores);
        spinnerProvedores.setAdapter(provedoresAdapter);
    }

}
