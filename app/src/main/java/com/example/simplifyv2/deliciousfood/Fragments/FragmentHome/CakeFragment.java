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

import com.example.simplifyv2.deliciousfood.Adapters.AdapterCakeFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicCake;
import com.example.simplifyv2.deliciousfood.R;

import java.util.List;

public class CakeFragment extends Fragment implements ViewCake {
    AdapterCakeFragment adapterCakeFragment;
    PresentLogicCake presentLogicCake;
    RecyclerView recyclerViewCakeFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake, container, false);
        recyclerViewCakeFragment = view.findViewById(R.id.recyclerViewCakeFragment);

        presentLogicCake = new PresentLogicCake(this);
        presentLogicCake.getDataCake();
        return view;
    }

    @Override
    public void ShowDataCake(List<HomeModel> homeModelList) {
        adapterCakeFragment = new AdapterCakeFragment(homeModelList, getContext());
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewCakeFragment.setLayoutManager(layoutManager);
        recyclerViewCakeFragment.setAdapter(adapterCakeFragment);
    }
}
