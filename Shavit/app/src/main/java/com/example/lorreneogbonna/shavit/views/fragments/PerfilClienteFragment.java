package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.activities.HomeBuscarClienteActivity;
import com.example.lorreneogbonna.shavit.views.activities.LoginActivity;

public class PerfilClienteFragment extends Fragment {

    public PerfilClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil_cliente, container, false);
        final Button buttonLogout = view.findViewById(R.id.LogoutCliente);
        final Button buttonEditar = view.findViewById(R.id.editarCliente);
        final TextView nome = view.findViewById(R.id.nomePerfilClinica);
        final TextView email = view.findViewById(R.id.emailPerfilClinica);
        final TextView telefone = view.findViewById(R.id.fonePerfilClinica);
        final TextView idade = view.findViewById(R.id.idadePerfilCliente);
        final TextView morada = view.findViewById(R.id.moradaPerfilClinica);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thiscontext, LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            Context thiscontext = container.getContext();
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(thiscontext, LoginActivity.class);
//                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
