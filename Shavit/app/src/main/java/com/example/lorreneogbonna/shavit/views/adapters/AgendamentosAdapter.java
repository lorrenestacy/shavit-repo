package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.utils.OnClickedItem;

import java.util.List;

public class AgendamentosAdapter extends RecyclerView.Adapter<AgendamentosAdapter.AgendamentoViewHolder> {

    private List<Agendamento> agendamentos;
    private OnClickedItem clickedItemListener;

    public AgendamentosAdapter(List<Agendamento> agendamentos, OnClickedItem clickedItemListener) {
        this.agendamentos = agendamentos;
        this.clickedItemListener = clickedItemListener;
    }

    @NonNull
    @Override
    public AgendamentoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = layoutInflater.inflate(R.layout.item_agendamento_card,viewGroup,false);

        return new AgendamentoViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendamentoViewHolder agendamentoViewHolder, int position) {

        Agendamento agendamento = agendamentos.get(position);

        agendamentoViewHolder.lblAgendamentoData.setText(agendamento.getPedido().getData());
        agendamentoViewHolder.lblAgendamentoHora.setText(agendamento.getPedido().getHorario());
        agendamentoViewHolder.lblNomeProvedor.setText(agendamento.getProvedor().getNome());
        agendamentoViewHolder.lblNomeServico.setText(agendamento.getPedido().getServico().getNome());
    }

    @Override
    public int getItemCount() {
        return agendamentos.size();
    }

    public class AgendamentoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblAgendamentoData;
        private TextView lblAgendamentoHora;
        private TextView lblNomeProvedor;
        private TextView lblNomeServico;

        public AgendamentoViewHolder(@NonNull View itemView) {

            super(itemView);

            lblAgendamentoData = itemView.findViewById(R.id.lblAgendamentoHora);
            lblAgendamentoHora = itemView.findViewById(R.id.lblAgendamentoData);
            lblNomeProvedor = itemView.findViewById(R.id.lblNomeProvedorListaAgendamento);
            lblNomeServico = itemView.findViewById(R.id.lblNomeServicoListaAgendamento);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItemListener.onclick(v,this.getLayoutPosition());
        }
    }

}