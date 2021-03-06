package com.example.simplifyv2.deliciousfood.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadImageBitmapFromURL;
import com.example.simplifyv2.deliciousfood.View.DetailActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDrinkFragment extends RecyclerView.Adapter<AdapterDrinkFragment.MyHolder> {
    List<HomeModel> homeModelList;
    Context context;
    public AdapterDrinkFragment(List<HomeModel> homeModelList, Context context) {
        this.homeModelList = homeModelList;
        this.context = context;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtDrinkName, txtContent, txtPrice;
        ImageView imageViewDrink;
        CardView cardViewDrink;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDrink = itemView.findViewById(R.id.imageViewDrink);
            txtDrinkName = itemView.findViewById(R.id.txtDrinkName);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            cardViewDrink = itemView.findViewById(R.id.cardViewDrink);
        }
    }
    @NonNull
    @Override
    public AdapterDrinkFragment.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_drink, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDrinkFragment.MyHolder myHolder, int i) {
        final HomeModel homeModel = homeModelList.get(i);
        DownloadImageBitmapFromURL downloadImageBitmapFromURL = new DownloadImageBitmapFromURL();
        myHolder.txtDrinkName.setText(homeModel.getTenmonan());
        myHolder.txtContent.setText(homeModel.getMotamonan());
        myHolder.txtPrice.setText(String.valueOf(homeModel.getGiaban())+"vnđ");
        downloadImageBitmapFromURL.DownloadImage(homeModelList, myHolder.imageViewDrink, i);
        myHolder.cardViewDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDetail = new Intent(context, DetailActivity.class);
                iDetail.putExtra("ten", homeModel.getTenmonan());
                iDetail.putExtra("mota", homeModel.getMotamonan());
                iDetail.putExtra("giaban", String.valueOf(homeModel.getGiaban()));
                iDetail.putExtra("id_monan", homeModel.getId_monan());
                iDetail.putExtra("hinhanh", homeModel.getHinhanhmonan());
                iDetail.putExtra("id_loaimonan", homeModel.getId_loaimoanan());
                context.startActivity(iDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }
}
