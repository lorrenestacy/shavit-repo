package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        final TextView nome = view.findViewById(R.id.nomePerfilClinica);
        final TextView email = view.findViewById(R.id.emailPerfilClinica);
        final TextView telefone = view.findViewById(R.id.fonePerfilClinica);
        final TextView morada = view.findViewById(R.id.moradaPerfilClinica);
        final TextView nif = view.findViewById(R.id.nifPerfilClinica);

        String nomeUsuario = getArguments().getString("nomeUsuario");
        String moradaUsuario = getArguments().getString("moradaUsuario");
        String emailUsuario = getArguments().getString("emailUsuario");
        String telefoneUsuario = getArguments().getString("telefoneUsuario");
        String nifUsuario = getArguments().getString("nifUsuario");

        String s1 = nomeUsuario.substring(0, 1).toUpperCase();
        String nameCapitalized = s1 + nomeUsuario.substring(1);

        nome.setText(nome.getText()+"  "+nameCapitalized);
        email.setText(email.getText()+"  "+emailUsuario);
        telefone.setText(telefone.getText()+"  "+telefoneUsuario);
        nif.setText(nif.getText()+"  "+nifUsuario);
        morada.setText(morada.getText()+"  "+moradaUsuario);


        final LinearLayout textsPerfilClinica = view.findViewById(R.id.textsPerfilClinica);
        final LinearLayout inputsEditarClinica = view.findViewById(R.id.inputsEditarClinica);
        final LinearLayout perfilButtons = view.findViewById(R.id.perfilButtons);
        final LinearLayout editarPerfilButtons = view.findViewById(R.id.editarPerfilButtons);

        final Button buttonLogout = view.findViewById(R.id.logoutClinica);
        final Button buttonEditar = view.findViewById(R.id.editarClinica);
        final Button buttonCancelar = view.findViewById(R.id.cancelarEditar);
        final Button buttonSalvar = view.findViewById(R.id.salvarEditar);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thiscontext, LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsPerfilClinica.setVisibility(View.GONE);
                inputsEditarClinica.setVisibility(View.VISIBLE);
                perfilButtons.setVisibility(View.GONE);
                editarPerfilButtons.setVisibility(View.VISIBLE);
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsPerfilClinica.setVisibility(View.VISIBLE);
                inputsEditarClinica.setVisibility(View.GONE);
                perfilButtons.setVisibility(View.VISIBLE);
                editarPerfilButtons.setVisibility(View.GONE);
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsPerfilClinica.setVisibility(View.VISIBLE);
                inputsEditarClinica.setVisibility(View.GONE);
                perfilButtons.setVisibility(View.VISIBLE);
                editarPerfilButtons.setVisibility(View.GONE);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
