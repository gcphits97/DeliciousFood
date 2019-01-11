package com.example.simplifyv2.deliciousfood.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.CakeFragment;
import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.DrinkFragment;
import com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome.FastFoodFragment;

public class AdapterViewPagerHomeFragment extends FragmentPagerAdapter {

    private String tabTitle[] = new String[]{"Fast Food", "Drink & Tea", "Cakes"};
    FastFoodFragment fastFoodFragment;
    CakeFragment cakeFragment;
    DrinkFragment drinkFragment;
    private static final int count = 3;

    public AdapterViewPagerHomeFragment(FragmentManager fm) {
        super(fm);
        fastFoodFragment = new FastFoodFragment();
        cakeFragment = new CakeFragment();
        drinkFragment = new DrinkFragment();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return fastFoodFragment;
            case 1:
                return cakeFragment;
            case 2:
                return drinkFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

}
