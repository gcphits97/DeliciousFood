package com.example.simplifyv2.deliciousfood.Fragments.FragmentHome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterFastFoodFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicFastFood;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadImageBitmapFromURL;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FastFoodFragment extends Fragment implements View.OnClickListener, ViewFastFood {
    PresentLogicFastFood presentLogicFastFood;
    RecyclerView recyclerViewFastFoodFragment;
    AdapterFastFoodFragment adapterFastFoodFragment;
    ViewFlipper viewFlipperFastFood;
    float initialX;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fastfood, container, false);

        recyclerViewFastFoodFragment = view.findViewById(R.id.recyclerViewFastFoodFragment);
        viewFlipperFastFood = view.findViewById(R.id.viewFlipperFastFood);

        presentLogicFastFood = new PresentLogicFastFood(this);
        presentLogicFastFood.getDataFastFood();
        presentLogicFastFood.getDataFastFoodBanChay();
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

    @Override
    public void ShowDataFastFoodViewFlipper(List<HomeModel> listBanChay) {
        DownloadImageBitmapFromURL downloadImageBitmapFromURL = new DownloadImageBitmapFromURL();
        int n = listBanChay.size();
        for (int i = 0; i < n; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            downloadImageBitmapFromURL.DownloadImage(listBanChay, imageView, i);
            viewFlipperFastFood.addView(imageView, i);
        }
        viewFlipperFastFood.setFlipInterval(5000);
        viewFlipperFastFood.startFlipping();
    }
}