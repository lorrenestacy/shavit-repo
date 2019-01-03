package com.example.lorreneogbonna.shavit.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorreneogbonna.shavit.R;
import com.example.lorreneogbonna.shavit.views.adapters.TabPageAdapter;

public class GerenciamentoAgendamentosFragment extends Fragment {

    private TabLayout tabsAgendamentos;
    private ViewPager viewPager;

    public GerenciamentoAgendamentosFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gerenciamento_agendamentos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        this.tabsAgendamentos = getView().findViewById(R.id.tabsGerenciamentoAgendamentos);
        this.viewPager = getView().findViewById(R.id.viewPagerAgendamentos);

        setupViewPagerTabs();
        tabsAgendamentos.setupWithViewPager(viewPager);
    }

    private void setupViewPagerTabs() {

        TabPageAdapter tabsPageAdapter = new TabPageAdapter(getChildFragmentManager());

        //viewPager's tabs
        tabsPageAdapter.addFragment(new AgendamentosClinicaFragment(), "Marcados");
        tabsPageAdapter.addFragment(new PedidosClinicaFragment(), "Pedidos");

        viewPager.setAdapter(tabsPageAdapter);
    }

}
