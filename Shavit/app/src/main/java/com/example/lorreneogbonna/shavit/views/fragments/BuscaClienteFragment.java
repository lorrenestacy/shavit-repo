package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.lorreneogbonna.shavit.R;


public class BuscaClienteFragment extends Fragment {
    public BuscaClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busca_cliente, container, false);

        RadioButton maleRadioButton, femaleRadioButton;

        maleRadioButton = (RadioButton) view.findViewById(R.id.comumBusca);
        femaleRadioButton = (RadioButton) view.findViewById(R.id.dataHoraBusca);
        Button buscar = view.findViewById(R.id.buttonBuscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
                //carregar lista
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
