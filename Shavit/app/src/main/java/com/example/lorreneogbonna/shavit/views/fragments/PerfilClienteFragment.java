package com.example.lorreneogbonna.shavit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
        final Button buttonSalvar = view.findViewById(R.id.salvarEdit);
        final Button buttonCancelar = view.findViewById(R.id.cancelarEdit);

        final TextView nome = view.findViewById(R.id.nomePerfilCliente);
        final TextView email = view.findViewById(R.id.emailPerfilCliente);
        final TextView telefone = view.findViewById(R.id.fonePerfilCliente);
        final TextView idade = view.findViewById(R.id.idadePerfilCliente);
        final TextView morada = view.findViewById(R.id.moradaPerfilCliente);
        final TextView nif = view.findViewById(R.id.nifPerfilClinica);

        final LinearLayout editInputsLayout = view.findViewById(R.id.editInputsLayout);
        final LinearLayout textsLayout = view.findViewById(R.id.perfilTextLayout);
        final LinearLayout firstButtonsLayout = view.findViewById(R.id.firstButtonsLayout);
        final LinearLayout editButtonsLayout = view.findViewById(R.id.editButtonsLayout);

        final TextInputEditText editNome = view.findViewById(R.id.editNome);
        final TextInputEditText editEmail = view.findViewById(R.id.editEmail);
        final TextInputEditText editIdade = view.findViewById(R.id.editIdade);
        final TextInputEditText editMorada = view.findViewById(R.id.editMorada);
        final TextInputEditText editNif = view.findViewById(R.id.editNif);
        final TextInputEditText editTelefone = view.findViewById(R.id.editTelefone);

        int idadeUsuario = getArguments().getInt("idadeUsuario");
        String nomeUsuario = getArguments().getString("nomeUsuario");
        String moradaUsuario = getArguments().getString("moradaUsuario");
        String emailUsuario = getArguments().getString("emailUsuario");
        String telefoneUsuario = getArguments().getString("telefoneUsuario");
        String nifUsuario = getArguments().getString("nifUsuario");

        idade.setText(idade.getText()+"  "+Integer.toString(idadeUsuario));

        String s1 = nomeUsuario.substring(0, 1).toUpperCase();
        String nameCapitalized = s1 + nomeUsuario.substring(1);

        nome.setText(nome.getText()+"  "+nameCapitalized);
        email.setText(email.getText()+"  "+emailUsuario);
        telefone.setText(telefone.getText()+"  "+telefoneUsuario);
        nif.setText(nif.getText()+"  "+nifUsuario);
        morada.setText(morada.getText()+"  "+moradaUsuario);

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
                textsLayout.setVisibility(View.GONE);
                editButtonsLayout.setVisibility(View.VISIBLE);
                firstButtonsLayout.setVisibility(View.GONE);
                editInputsLayout.setVisibility(View.VISIBLE);
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //salvar as infos do edit
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textsLayout.setVisibility(View.VISIBLE);
                editButtonsLayout.setVisibility(View.GONE);
                firstButtonsLayout.setVisibility(View.VISIBLE);
                editInputsLayout.setVisibility(View.GONE);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
