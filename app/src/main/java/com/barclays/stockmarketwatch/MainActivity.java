package com.barclays.stockmarketwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.barclays.stockmarketwatch.common.SwipeAdapter;
import com.barclays.stockmarketwatch.view.HomeFragment;
import com.barclays.stockmarketwatch.view.SettingsFragment;
import com.barclays.stockmarketwatch.view.WatchListFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SwipeAdapter mSwipeAdapter;

    @BindView(R.id.tabLayout)
    TabLayout tbLayout;

    @BindView(R.id.viewPager)
    ViewPager vbPager;

    private HomeFragment homeFragment;
    private WatchListFragment watchListFragment;
    private SettingsFragment settingsFragment;


    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.content_frame)
    FrameLayout mFrame;

    @BindView(R.id.container)
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        homeFragment = new HomeFragment();
        watchListFragment = new WatchListFragment();
        settingsFragment = new SettingsFragment();
        showPager(1);

    }

    private void showPager(int defaultSelection){
        mSwipeAdapter = new SwipeAdapter(getSupportFragmentManager());

        mSwipeAdapter.addFragment(homeFragment, "Home");
        mSwipeAdapter.addFragment(watchListFragment, "WatchList" );
        mSwipeAdapter.addFragment(settingsFragment, "Settings");

        vbPager.setAdapter(mSwipeAdapter);

        tbLayout.setupWithViewPager(vbPager);

        tbLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
                vbPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        LinearLayout linearLayout = (LinearLayout) tbLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getResources().getColor(R.color.colorPrimary));
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
    }
}