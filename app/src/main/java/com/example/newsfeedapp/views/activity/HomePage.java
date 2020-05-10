package com.example.newsfeedapp.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.newsfeedapp.R;
import com.example.newsfeedapp.constants.GenericConstants;
import com.example.newsfeedapp.views.adapter.TabsAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        setToolbar();
        setTabs();
    }

    private void setToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_home));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setTabs() {
        TabLayout tabLayout =  findViewById(R.id.tab_layout);
        final ViewPager viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.The_times_of_india));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.Hindustantimes));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.Livemint));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.Moneycontrol));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.Indianexpress));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.Youtube));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.the_hindu));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.fox_news));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.The_wall_street_journal));
        tabLayout.addTab(tabLayout.newTab().setText(GenericConstants.nytimes));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        int limit = (tabsAdapter.getCount() > 1 ? tabsAdapter.getCount() - 1 : 1);
        viewPager.setOffscreenPageLimit(limit);
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
