package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class ProvedoresAdapter extends RecyclerView.Adapter<ProvedoresAdapter.ProvedorViewHolder> {

    private List<Provedor> provedores;
    private OnClickedItem clickedItemListener;

    public ProvedoresAdapter(List<Provedor> provedores, OnClickedItem clickedItemListener) {
        this.provedores = provedores;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public ProvedorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_provedor_card,viewGroup,false);

        return new ProvedorViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvedorViewHolder servicoViewHolder, int position) {

        Provedor provedor = provedores.get(position);

        servicoViewHolder.lblNomeProvedor.setText(provedor.getNome());
        servicoViewHolder.lblTelefoneProvedor.setText(provedor.getTelefone());
    }

    @Override
    public int getItemCount() {
        return provedores.size();
    }

    public class ProvedorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblNomeProvedor;
        private TextView lblTelefoneProvedor;

        public ProvedorViewHolder(@NonNull View itemView) {

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