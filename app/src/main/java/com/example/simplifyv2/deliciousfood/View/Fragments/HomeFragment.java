package com.example.simplifyv2.deliciousfood.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterViewPagerHomeFragment;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.View.SearchViewActivity;

public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener, View.OnClickListener {
    private Toolbar toolbar_home_fragment;
    private ViewPager viewpagerHomeFragment;
    private AdapterViewPagerHomeFragment viewPagerAdapter;
    private TabLayout tabLayoutFragmentHome;
    Button btnSearch;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toolbar_home_fragment = view.findViewById(R.id.toolbar_home_fragment);
        viewpagerHomeFragment = view.findViewById(R.id.viewpagerHomeFragment);
        tabLayoutFragmentHome = view.findViewById(R.id.tabLayoutFragmentHome);
        btnSearch = view.findViewById(R.id.btnSearch);
        //toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home_fragment);
        toolbar_home_fragment.setTitle("");
        //view pager
        viewPagerAdapter = new AdapterViewPagerHomeFragment(getFragmentManager());
        viewpagerHomeFragment.setAdapter(viewPagerAdapter);
        viewpagerHomeFragment.addOnPageChangeListener(this);
        tabLayoutFragmentHome.addOnTabSelectedListener(this);
        tabLayoutFragmentHome.setupWithViewPager(viewpagerHomeFragment, true);
        btnSearch.setOnClickListener(this);
        viewPagerAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                viewpagerHomeFragment.setCurrentItem(0);
                break;
            case 1:
                viewpagerHomeFragment.setCurrentItem(1);
                break;
            case 2:
                viewpagerHomeFragment.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                viewpagerHomeFragment.setCurrentItem(0);
                break;
            case 1:
                viewpagerHomeFragment.setCurrentItem(1);
                break;
            case 2:
                viewpagerHomeFragment.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                viewpagerHomeFragment.setCurrentItem(0);
                break;
            case 1:
                viewpagerHomeFragment.setCurrentItem(1);
                break;
            case 2:
                viewpagerHomeFragment.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                getActivity().startActivity(new Intent(getContext(), SearchViewActivity.class));
                break;
        }
    }
}
