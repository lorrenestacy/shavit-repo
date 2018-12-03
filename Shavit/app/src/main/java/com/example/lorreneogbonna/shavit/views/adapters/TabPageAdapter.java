package com.example.lorreneogbonna.shavit.views.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPageAdapter extends FragmentPagerAdapter {

    private List<TitledFragment> fragmentList;

    public TabPageAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i).fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).title;
    }

    /**
     * Use to add to the list of fragments handled by current adapter.
     * Tabs will display title passed as parameter.
     * */
    public void addFragment (Fragment fragment, String title) {
        this.fragmentList.add(new TitledFragment(fragment,title));
    }

    /**
     * Contains a fragment and a title.
     * Stored in the list of current adapter.
     * */
    private class TitledFragment {

        private Fragment fragment;
        private String title;

        public TitledFragment (Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }
    }
}