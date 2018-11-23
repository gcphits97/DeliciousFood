package com.example.simplifyv2.deliciousfood.Server;

import android.widget.ImageView;

import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DownloadImageBitmapFromURL {
    public void DownloadImage(List<HomeModel> homeModelList, ImageView imageViewFlipper, int i) {
        Picasso.get().load(homeModelList.get(i).getHinhanhmonan())
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(imageViewFlipper);
    }
}
