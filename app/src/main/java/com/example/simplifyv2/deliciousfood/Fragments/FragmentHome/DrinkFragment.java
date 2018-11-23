package com.example.simplifyv2.deliciousfood.Fragments.FragmentHome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterDrinkFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicDrink;
import com.example.simplifyv2.deliciousfood.R;

import java.util.List;

public class DrinkFragment extends Fragment implements ViewDrink {
    PresentLogicDrink presentLogicDrink;
    RecyclerView recyclerViewDrinkFragment;
    AdapterDrinkFragment adapterDrinkFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);
        recyclerViewDrinkFragment = view.findViewById(R.id.recyclerViewDrinkFragment);

        presentLogicDrink = new PresentLogicDrink(this);
        presentLogicDrink.getDataDrink();
        return view;
    }

    @Override
    public void ShowDataDrink(List<HomeModel> homeModelList) {
        adapterDrinkFragment = new AdapterDrinkFragment(homeModelList, getContext());
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewDrinkFragment.setLayoutManager(layoutManager);
        recyclerViewDrinkFragment.setAdapter(adapterDrinkFragment);
    }
}
