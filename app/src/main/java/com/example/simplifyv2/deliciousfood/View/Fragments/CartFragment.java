package com.example.simplifyv2.deliciousfood.View.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterCartFragment;
import com.example.simplifyv2.deliciousfood.Models.DonHangModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresenterCartFragment;
import com.example.simplifyv2.deliciousfood.R;

import java.util.List;

public class CartFragment extends Fragment implements ViewCart {
    RecyclerView recyclerViewCartFragment;
    PresenterCartFragment presenterCartFragment;
    AdapterCartFragment adapterCartFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerViewCartFragment = view.findViewById(R.id.recyclerViewCartFragment);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenterCartFragment = new PresenterCartFragment(this, getContext());
        presenterCartFragment.getDataDonHang();
    }

    @Override
    public void ShowDataDonHang(List<DonHangModel> donHangModelList) {
        adapterCartFragment = new AdapterCartFragment(getContext(), donHangModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewCartFragment.setLayoutManager(layoutManager);
        recyclerViewCartFragment.setAdapter(adapterCartFragment);
        adapterCartFragment.notifyDataSetChanged();
    }
}
