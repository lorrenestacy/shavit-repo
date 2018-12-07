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

public class ServicosFragment extends Fragment {

    private TabLayout tabsServices;
    private ViewPager viewPager;

    public ServicosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servicos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        this.tabsServices = getView().findViewById(R.id.tabsServices);
        this.viewPager = getView().findViewById(R.id.viewPager);

        setupViewPagerTabs();
        tabsServices.setupWithViewPager(viewPager);
    }

    private void setupViewPagerTabs () {

        TabPageAdapter tabsPageAdapter = new TabPageAdapter(getChildFragmentManager());

        //viewPager's tabs
        tabsPageAdapter.addFragment(new ServicosListFragment(), "Serviços");
        tabsPageAdapter.addFragment(new ProvedoresListClinicaFragment(), "Provedores");

        viewPager.setAdapter(tabsPageAdapter);
    }

}
