package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.Model.Promocao;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class PromocaoAdapter extends RecyclerView.Adapter<PromocaoAdapter.PromocaoViewHolder> {

    private List<Promocao> promocoes;
    private OnClickedItem clickedItemListener;

    public PromocaoAdapter(List<Promocao> promocoes, OnClickedItem clickedItemListener) {
        this.promocoes = promocoes;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public PromocaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_promocao_card,viewGroup,false);

        return new PromocaoViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PromocaoViewHolder agendamentoViewHolder, int position) {

        Promocao promocao = promocoes.get(position);

        agendamentoViewHolder.lblAgendamentoData.setText(promocao.getDercricao());
        agendamentoViewHolder.lblAgendamentoHora.setText(promocao.getPreco());
//        agendamentoViewHolder.lblAgendamentoHora.setText(promocao.getPeriodo());
    }

    @Override
    public int getItemCount() {
        return promocoes.size();
    }

    public class PromocaoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblAgendamentoData;
        private TextView lblAgendamentoHora;

        public PromocaoViewHolder(@NonNull View itemView) {

            super(itemView);

            lblAgendamentoData = itemView.findViewById(R.id.lblAgendamentoHora);
            lblAgendamentoHora = itemView.findViewById(R.id.lblAgendamentoData);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItemListener.onclick(v,this.getLayoutPosition());
        }
    }

}