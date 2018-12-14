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

import com.example.simplifyv2.deliciousfood.Adapters.AdapterCakeFragment;
import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.Presenters.PresentLogicCake;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadImageBitmapFromURL;

import java.util.List;

public class CakeFragment extends Fragment implements ViewCake {
    AdapterCakeFragment adapterCakeFragment;
    PresentLogicCake presentLogicCake;
    RecyclerView recyclerViewCakeFragment;
    ViewFlipper viewFlipperCake;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake, container, false);
        recyclerViewCakeFragment = view.findViewById(R.id.recyclerViewCakeFragment);
        viewFlipperCake = view.findViewById(R.id.viewFlipperCake);

        presentLogicCake = new PresentLogicCake(this);
        presentLogicCake.getDataCake();
        presentLogicCake.getDataCakeBanChay();
        return view;
    }

    @Override
    public void ShowDataCake(List<HomeModel> homeModelList) {
        adapterCakeFragment = new AdapterCakeFragment(homeModelList, getContext());
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewCakeFragment.setLayoutManager(layoutManager);
        recyclerViewCakeFragment.setAdapter(adapterCakeFragment);
        adapterCakeFragment.notifyDataSetChanged();
    }

    @Override
    public void ShowDataCakeViewFlipper(List<HomeModel> listBanChay) {
        DownloadImageBitmapFromURL downloadImageBitmapFromURL = new DownloadImageBitmapFromURL();
        int n = listBanChay.size();
        for (int i = 0; i < n; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            downloadImageBitmapFromURL.DownloadImage(listBanChay, imageView, i);
            viewFlipperCake.addView(imageView, i);
        }
        viewFlipperCake.setFlipInterval(5000);
        viewFlipperCake.startFlipping();
    }
}
