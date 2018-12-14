package com.example.simplifyv2.deliciousfood.View.Fragments;

import android.content.Context;
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

import com.example.simplifyv2.deliciousfood.Adapters.AdapterViewPagerHomeFragment;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.FastFoodFragment;

public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private Toolbar toolbar_home_fragment;
    private ViewPager viewpagerHomeFragment;
    private AdapterViewPagerHomeFragment viewPagerAdapter;
    private TabLayout tabLayoutFragmentHome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toolbar_home_fragment = view.findViewById(R.id.toolbar_home_fragment);
        viewpagerHomeFragment = view.findViewById(R.id.viewpagerHomeFragment);
        tabLayoutFragmentHome = view.findViewById(R.id.tabLayoutFragmentHome);
        //toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_home_fragment);
        toolbar_home_fragment.setTitle("");
        //view pager
        viewPagerAdapter = new AdapterViewPagerHomeFragment(getFragmentManager());
        viewpagerHomeFragment.setAdapter(viewPagerAdapter);
        viewpagerHomeFragment.addOnPageChangeListener(this);
        viewPagerAdapter.notifyDataSetChanged();

        tabLayoutFragmentHome.setupWithViewPager(viewpagerHomeFragment, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
