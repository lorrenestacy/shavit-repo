package com.example.lorreneogbonna.shavit.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorreneogbonna.shavit.R;

public class PedidosClinicaFragment extends Fragment {

    public PedidosClinicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pedidos_clinica, container, false);

        // Inflate the layout for this fragment
        return view;
    }

}
