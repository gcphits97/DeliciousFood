package com.example.simplifyv2.deliciousfood.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.simplifyv2.deliciousfood.Fragments.FragmentHome.CakeFragment;
import com.example.simplifyv2.deliciousfood.Fragments.FragmentHome.DrinkFragment;
import com.example.simplifyv2.deliciousfood.Fragments.FragmentHome.FastFoodFragment;

public class AdapterViewPagerHomeFragment extends FragmentPagerAdapter {

    private String tabTitle[] = new String[]{"Fast Food", "Drink & Tea", "Cakes"};

    public AdapterViewPagerHomeFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FastFoodFragment();
            case 1:
                return new DrinkFragment();
            case 2:
                return new CakeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
