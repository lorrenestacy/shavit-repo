package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.LoginActivity;

public class PerfilClinicaFragment extends Fragment {

    public PerfilClinicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil_clinica, container, false);
        final Button buttonLogout = view.findViewById(R.id.logoutClinica);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thiscontext, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
