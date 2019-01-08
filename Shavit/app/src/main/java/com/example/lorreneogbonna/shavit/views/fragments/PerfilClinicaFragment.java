package com.example.lorreneogbonna.shavit.views.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lorreneogbonna.shavit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfilClinicaFragment extends Fragment {

    private Map<TextInputEditText, TextInputLayout> editableTextFields = new HashMap<>();
    private boolean isEditing = false;

    public PerfilClinicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_perfil_clinica, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        TextInputEditText txtNome = view.findViewById(R.id.fragmentoPerfilClinica_nome);
        TextInputLayout layoutNome = view.findViewById(R.id.fragmentoPerfilClinica_nomeLayout);
        editableTextFields.put(txtNome, layoutNome);

        TextInputEditText txtEmail = view.findViewById(R.id.fragmentoPerfilClinica_email);
        TextInputLayout layoutEmail = view.findViewById(R.id.fragmentoPerfilClinica_emailLayout);
        editableTextFields.put(txtEmail, layoutEmail);

        TextInputEditText txtMorada = view.findViewById(R.id.fragmentoPerfilClinica_morada);
        TextInputLayout layoutMorada = view.findViewById(R.id.fragmentoPerfilClinica_moradaLayout);
        editableTextFields.put(txtMorada, layoutMorada);

        TextInputEditText txtPhone = view.findViewById(R.id.fragmentoPerfilClinica_fone);
        TextInputLayout layoutPhone = view.findViewById(R.id.fragmentoPerfilClinica_foneLayout);
        editableTextFields.put(txtPhone, layoutPhone);

        TextInputEditText txtNif = view.findViewById(R.id.fragmentoPerfilClinica_nif);
        TextInputLayout layoutNif = view.findViewById(R.id.fragmentoPerfilClinica_nifLayout);
        editableTextFields.put(txtNif, layoutNif);

        Button btnConfirm = view.findViewById(R.id.fragmentoPerfilClinica_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isEditing) {
                    setFieldsAsEditable();
                    isEditing = true;

                    return;
                }

                //TODO save things in here
                isEditing = false;
                setFieldsAsNonEditable();
            }
        });

        Button btnLogout = view.findViewById(R.id.fragmentoPerfilClinica_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout operation
            }
        });

    }

    private void setFieldsAsEditable () {

        for (Map.Entry<TextInputEditText, TextInputLayout> entry : editableTextFields.entrySet()) {
            makeInputTextEditable(entry.getKey());
        }

    }

    private void setFieldsAsNonEditable () {
        for (Map.Entry<TextInputEditText, TextInputLayout> entry : editableTextFields.entrySet()) {
            makeInputTextNonEditable(entry.getKey());
        }
    }

    private void makeInputTextEditable (TextInputEditText inputText) {

        inputText.setClickable(true);
        inputText.setCursorVisible(true);
        inputText.setFocusable(true);
        inputText.setFocusableInTouchMode(true);

        //use a hash map to get layout as well. we can use 'getParentForAccessibility'
        TextInputLayout parentLayout = editableTextFields.get(inputText);
        parentLayout.setBoxBackgroundColor(Color.TRANSPARENT);
    }

    private void makeInputTextNonEditable (TextInputEditText inputText) {

        inputText.setClickable(false);
        inputText.setCursorVisible(false);
        inputText.setFocusable(false);
        inputText.setFocusableInTouchMode(false);

        TextInputLayout parentLayout = editableTextFields.get(inputText);
        parentLayout.setBoxBackgroundColor(getResources().getColor(R.color.grayInputTextFields));
    }

}
