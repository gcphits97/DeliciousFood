package com.example.simplifyv2.deliciousfood.View.Fragments.FragmentHome;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.simplifyv2.deliciousfood.Adapters.AdapterDrinkFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicDrink;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadImageBitmapFromURL;

import java.util.List;

public class DrinkFragment extends Fragment implements ViewDrink {
    PresentLogicDrink presentLogicDrink;
    RecyclerView recyclerViewDrinkFragment;
    AdapterDrinkFragment adapterDrinkFragment;
    ViewFlipper viewFlipperDrink;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);
        recyclerViewDrinkFragment = view.findViewById(R.id.recyclerViewDrinkFragment);
        viewFlipperDrink = view.findViewById(R.id.viewFlipperDrink);

        presentLogicDrink = new PresentLogicDrink(this);
        presentLogicDrink.getDataDrink();
        presentLogicDrink.getDataDrinkBanChay();
        return view;
    }

    @Override
    public void ShowDataDrink(List<HomeModel> homeModelList) {
        adapterDrinkFragment = new AdapterDrinkFragment(homeModelList, getContext());
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewDrinkFragment.setLayoutManager(layoutManager);
        recyclerViewDrinkFragment.setAdapter(adapterDrinkFragment);
        adapterDrinkFragment.notifyDataSetChanged();
    }

    @Override
    public void ShowDataDrinkViewFlipper(List<HomeModel> listBanChay) {
        DownloadImageBitmapFromURL downloadImageBitmapFromURL = new DownloadImageBitmapFromURL();
        int n = listBanChay.size();
        for (int i = 0; i < n; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            downloadImageBitmapFromURL.DownloadImage(listBanChay, imageView, i);
            viewFlipperDrink.addView(imageView, i);
        }
        viewFlipperDrink.setFlipInterval(5000);
        viewFlipperDrink.startFlipping();
    }
}
