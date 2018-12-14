package com.example.simplifyv2.deliciousfood.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.Models.DonHangModel;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.View.CartDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCartFragment extends RecyclerView.Adapter<AdapterCartFragment.MyHolder> {
    Context context;
    List<DonHangModel> donHangModelList;

    public AdapterCartFragment(Context context, List<DonHangModel> donHangModelList) {
        this.context = context;
        this.donHangModelList = donHangModelList;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCart;
        TextView txtAmountInCart, txtNameInCart, txtPriceInCart;
        CardView cardViewCart;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCart = itemView.findViewById(R.id.imageViewCart);
            txtAmountInCart = itemView.findViewById(R.id.txtAmountInCart);
            txtNameInCart = itemView.findViewById(R.id.txtNameInCart);
            txtPriceInCart = itemView.findViewById(R.id.txtPriceInCart);
            cardViewCart = itemView.findViewById(R.id.cardViewCart);
        }
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_order_in_cart, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        final DonHangModel donHangModel = donHangModelList.get(i);
        myHolder.txtAmountInCart.setText(" "+donHangModel.getSoluong());
        myHolder.txtPriceInCart.setText(" "+donHangModel.getTongtien()+"vnđ");
        myHolder.txtNameInCart.setText(donHangModel.getTenmonan());
        Picasso.get().load(donHangModel.getHinhanhmonan())
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(myHolder.imageViewCart);
        myHolder.cardViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCartDetail = new Intent(context, CartDetailActivity.class);
                iCartDetail.putExtra("tenmonan", donHangModel.getTenmonan());
                iCartDetail.putExtra("mota", donHangModel.getMotamonan());
                iCartDetail.putExtra("giaban", donHangModel.getGiaban());
                iCartDetail.putExtra("soluong", donHangModel.getSoluong());
                iCartDetail.putExtra("tongtien", donHangModel.getTongtien());
                iCartDetail.putExtra("id_donhang", donHangModel.getId_donhang());
                iCartDetail.putExtra("hinhanh", donHangModel.getHinhanhmonan());
                context.startActivity(iCartDetail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return donHangModelList.size();
    }
}
