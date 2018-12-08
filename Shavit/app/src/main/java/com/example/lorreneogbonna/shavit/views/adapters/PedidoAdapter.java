package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.Model.Promocao;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {

    private List<Pedido> pedidos;
    private OnClickedItem clickedItemListener;

    public PedidoAdapter(List<Pedido> pedidos, OnClickedItem clickedItemListener) {
        this.pedidos = pedidos;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_pedido_card,viewGroup,false);

        return new PedidoViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder pedidoViewHolder, int position) {

        Pedido pedido = pedidos.get(position);

        pedidoViewHolder.lblPedidoData.setText(pedido.getData());
        pedidoViewHolder.lblPedidoHora.setText(pedido.getHorario());
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public class PedidoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblPedidoData;
        private TextView lblPedidoHora;

        public PedidoViewHolder(@NonNull View itemView) {

            super(itemView);

            lblPedidoData = itemView.findViewById(R.id.lblPedidoData);
            lblPedidoHora = itemView.findViewById(R.id.lblPedidoHora);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItemListener.onclick(v,this.getLayoutPosition());
        }
    }

}