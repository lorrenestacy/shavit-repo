package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class ServicosAdapter extends RecyclerView.Adapter<ServicosAdapter.ServicoViewHolder> {

    private List<Servico> servicos;
    private OnClickedItem clickedItemListener;

    public ServicosAdapter (List<Servico> servicos, OnClickedItem clickedItemListener) {
        this.servicos = servicos;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public ServicoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_servico_card,viewGroup,false);

        return new ServicoViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoViewHolder servicoViewHolder, int position) {

        Servico servico = servicos.get(position);

        servicoViewHolder.lblNomeServico.setText(servico.getNome());
        servicoViewHolder.lblDescricaoServico.setText(servico.getDescricao());
    }

    @Override
    public int getItemCount() {
        return servicos.size();
    }

    public class ServicoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblNomeServico;
        private TextView lblDescricaoServico;

        public ServicoViewHolder(@NonNull View itemView) {

            super(itemView);

            lblNomeServico = itemView.findViewById(R.id.lblNomeServico);
            lblDescricaoServico = itemView.findViewById(R.id.lblDescricaoServico);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItemListener.onclick(v,this.getLayoutPosition());
        }
    }

}