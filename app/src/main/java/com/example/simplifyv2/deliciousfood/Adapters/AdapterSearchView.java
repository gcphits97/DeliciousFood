package com.example.simplifyv2.deliciousfood.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.Models.HomeModel;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadImageBitmapFromURL;
import com.example.simplifyv2.deliciousfood.View.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterSearchView extends RecyclerView.Adapter<AdapterSearchView.MyHolder> implements Filterable {
    List<HomeModel> homeModelList;
    Context context;
    List<HomeModel> homeModelListFull;

    public AdapterSearchView(List<HomeModel> homeModelList, Context context) {
        this.homeModelList = homeModelList;
        this.context = context;
        homeModelListFull = new ArrayList<>(homeModelList);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageSPSearch;
        TextView txtGiaBanSearch, txtTenMonAnSearch;
        CardView cardViewSearchResult;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageSPSearch = itemView.findViewById(R.id.imageSPSearch);
            txtGiaBanSearch = itemView.findViewById(R.id.txtGiaBanSearch);
            txtTenMonAnSearch = itemView.findViewById(R.id.txtTenMonAnSearch);
            cardViewSearchResult = itemView.findViewById(R.id.cardViewSearchResult);
        }
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.custom_result_search, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        final HomeModel homeModel = homeModelList.get(i);
        DownloadImageBitmapFromURL downloadImageBitmapFromURL = new DownloadImageBitmapFromURL();
        downloadImageBitmapFromURL.DownloadImage(homeModelList, myHolder.imageSPSearch, i);
        myHolder.txtTenMonAnSearch.setText(homeModel.getTenmonan());
        myHolder.txtGiaBanSearch.setText(homeModel.getGiaban()+"vnđ");
        myHolder.cardViewSearchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSearch = new Intent(context, DetailActivity.class);
                iSearch.putExtra("ten", homeModel.getTenmonan());
                iSearch.putExtra("mota", homeModel.getMotamonan());
                iSearch.putExtra("giaban", String.valueOf(homeModel.getGiaban()));
                iSearch.putExtra("id_monan", homeModel.getId_monan());
                iSearch.putExtra("hinhanh", homeModel.getHinhanhmonan());
                iSearch.putExtra("id_loaimonan", homeModel.getId_loaimoanan());
                context.startActivity(iSearch);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    @Override
    public Filter getFilter() {
        return homeModelFilter;
    }

    private Filter homeModelFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<HomeModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(homeModelListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (HomeModel value: homeModelListFull) {
                    if (value.getTenmonan().toLowerCase().contains(filterPattern)) {
                        filteredList.add(value);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values =  filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            homeModelList.clear();
            homeModelList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
