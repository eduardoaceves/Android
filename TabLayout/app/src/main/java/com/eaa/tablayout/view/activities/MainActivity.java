package com.eaa.tablayout.view.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.eaa.tablayout.R;
import com.eaa.tablayout.view.adapters.ViewPagerAdapter;
import com.eaa.tablayout.view.fragments.FragmentEigth;
import com.eaa.tablayout.view.fragments.FragmentFive;
import com.eaa.tablayout.view.fragments.FragmentFour;
import com.eaa.tablayout.view.fragments.FragmentNine;
import com.eaa.tablayout.view.fragments.FragmentOne;
import com.eaa.tablayout.view.fragments.FragmentSeven;
import com.eaa.tablayout.view.fragments.FragmentSix;
import com.eaa.tablayout.view.fragments.FragmentTen;
import com.eaa.tablayout.view.fragments.FragmentThree;
import com.eaa.tablayout.view.fragments.FragmentTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpViewerPager(viewPager);
        tabs.setupWithViewPager(viewPager);
    }

    private void setUpViewerPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "ONE");
        adapter.addFragment(new FragmentTwo(), "TWO");
        adapter.addFragment(new FragmentThree(), "THREE");
        adapter.addFragment(new FragmentFour(), "FOUR");
        adapter.addFragment(new FragmentFive(), "FIVE");
        adapter.addFragment(new FragmentSix(), "SIX");
        adapter.addFragment(new FragmentSeven(), "SEVEN");
        adapter.addFragment(new FragmentEigth(), "EIGHT");
        adapter.addFragment(new FragmentNine(), "NINE");
        adapter.addFragment(new FragmentTen(), "TEN");
        viewPager.setAdapter(adapter);
    }


}
