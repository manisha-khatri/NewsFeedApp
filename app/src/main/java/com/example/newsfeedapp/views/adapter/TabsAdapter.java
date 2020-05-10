package com.example.newsfeedapp.views.adapter;


import com.example.newsfeedapp.constants.GenericConstants;
import com.example.newsfeedapp.views.fragment.NewsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    public TabsAdapter(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public Fragment getItem(int position){

        switch (position){
            case 0:  return NewsFragment.getNewsInstance(GenericConstants.The_times_of_india);
            case 1:  return NewsFragment.getNewsInstance(GenericConstants.Hindustantimes);
            case 2: return NewsFragment.getNewsInstance(GenericConstants.Livemint);
            case 3:  return NewsFragment.getNewsInstance(GenericConstants.Moneycontrol);
            case 4:  return NewsFragment.getNewsInstance(GenericConstants.Indianexpress);
            case 5: return NewsFragment.getNewsInstance(GenericConstants.Youtube);
            case 6:  return NewsFragment.getNewsInstance(GenericConstants.the_hindu);
            case 7:  return NewsFragment.getNewsInstance(GenericConstants.fox_news);
            case 8: return NewsFragment.getNewsInstance(GenericConstants.The_wall_street_journal);
            case 9: return NewsFragment.getNewsInstance(GenericConstants.nytimes);

            default: return null;
        }
    }
}