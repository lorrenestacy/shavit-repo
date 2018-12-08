package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.dummy.DummyContent.DummyItem;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class resultadoBuscaAdapter extends RecyclerView.Adapter<resultadoBuscaAdapter.resultadoBuscaViewHolder> {

    private List<Servico> servicos;
    private OnClickedItem clickedItemListener;

    public resultadoBuscaAdapter(List<Servico> servicos, OnClickedItem clickedItemListener) {
        this.servicos = servicos;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public resultadoBuscaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_provedor_card,viewGroup,false);

        return new resultadoBuscaViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull resultadoBuscaViewHolder servicoViewHolder, int position) {

        Servico servico = servicos.get(position);

//        servicoViewHolder.lblNomeProvedor.setText(servico.getNome());
//        servicoViewHolder.lblTelefoneProvedor.setText(servico.getTelefone());
    }

    @Override
    public int getItemCount() {
        return servicos.size();
    }

    public class resultadoBuscaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblNomeProvedor;
        private TextView lblTelefoneProvedor;

        public resultadoBuscaViewHolder(@NonNull View itemView) {

            super(itemView);

            lblNomeProvedor = itemView.findViewById(R.id.lblNomeProvedor);
            lblTelefoneProvedor = itemView.findViewById(R.id.lblTelefoneProvedor);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItemListener.onclick(v,this.getLayoutPosition());
        }
    }
}
