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
import com.example.simplifyv2.deliciousfood.View.DetailActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCakeFragment extends RecyclerView.Adapter<AdapterCakeFragment.MyHolder> {
    List<HomeModel> homeModelList;
    Context context;
    public AdapterCakeFragment(List<HomeModel> homeModelList, Context context) {
        this.homeModelList = homeModelList;
        this.context = context;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtCakeName, txtContent, txtPrice;
        ImageView imageViewCake;
        CardView cardViewCake;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCake = itemView.findViewById(R.id.imageViewCake);
            txtCakeName = itemView.findViewById(R.id.txtCakeName);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            cardViewCake = itemView.findViewById(R.id.cardViewCake);
        }
    }
    @NonNull
    @Override
    public AdapterCakeFragment.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_cake, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCakeFragment.MyHolder myHolder, int i) {
        HomeModel homeModel = homeModelList.get(i);
        myHolder.txtCakeName.setText(homeModel.getTenmonan());
        myHolder.txtContent.setText(homeModel.getMotamonan());
        myHolder.txtPrice.setText(String.valueOf(homeModel.getGiaban())+"vnđ");
        DownloadImageBitmapFromURL(homeModel, myHolder.imageViewCake);
        myHolder.cardViewCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDetail = new Intent(context, DetailActivity.class);
                context.startActivity(iDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }
    private void DownloadImageBitmapFromURL(HomeModel homeModel, ImageView imageViewCake) {
        Picasso.get().load(homeModel.getHinhanhmonan())
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(imageViewCake, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }
}
