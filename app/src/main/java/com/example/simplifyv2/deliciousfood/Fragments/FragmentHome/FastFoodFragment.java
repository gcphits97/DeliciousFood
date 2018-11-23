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

import com.example.simplifyv2.deliciousfood.Adapters.AdapterFastFoodFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicFastFood;
import com.example.simplifyv2.deliciousfood.R;

import java.util.List;

public class FastFoodFragment extends Fragment implements View.OnClickListener, ViewFastFood {
    PresentLogicFastFood presentLogicFastFood;
    RecyclerView recyclerViewFastFoodFragment;
    AdapterFastFoodFragment adapterFastFoodFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fastfood, container, false);

        recyclerViewFastFoodFragment = view.findViewById(R.id.recyclerViewFastFoodFragment);

        presentLogicFastFood = new PresentLogicFastFood(this);
        presentLogicFastFood.getDataFastFood();
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void ShowDataFastFood(List<HomeModel> homeModelList) {
        adapterFastFoodFragment = new AdapterFastFoodFragment(homeModelList, getContext());
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewFastFoodFragment.setLayoutManager(layoutManager);
        recyclerViewFastFoodFragment.setAdapter(adapterFastFoodFragment);
    }
}
