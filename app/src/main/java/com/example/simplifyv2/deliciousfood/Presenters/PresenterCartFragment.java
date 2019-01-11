package com.example.simplifyv2.deliciousfood.Presenters;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.simplifyv2.deliciousfood.Models.DonHangModel;
import com.example.simplifyv2.deliciousfood.Models.JSONDonHang;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONData;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.Fragments.ViewCart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PresenterCartFragment implements ImpCart {
    ViewCart viewCart;
    Path path;
    Context context;

    public PresenterCartFragment(ViewCart viewCart, Context context) {
        this.viewCart = viewCart;
        this.context = context;
        path = new Path();
    }

    @Override
    public void getDataDonHang() {
        String dataDonHang = "";
        List<DonHangModel> donHangModelList;
        List<DonHangModel> donHangModels = new ArrayList<>();
        SharedPreferences recived = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        int id_khachhang = recived.getInt("id", 0);

        DownloadJSONData downloadJSONData = new DownloadJSONData(path.getPath_donhang());
        downloadJSONData.execute();
        try {
            dataDonHang = downloadJSONData.get();
            JSONDonHang jsonDonHang = new JSONDonHang();
            donHangModelList = jsonDonHang.ParserJSONDonHang(dataDonHang);

            for (DonHangModel donHangModel: donHangModelList) {
                if (donHangModel.getId_khachhang() == id_khachhang) {
                    donHangModels.add(donHangModel);
                }
            }
            viewCart.ShowDataDonHang(donHangModels);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
