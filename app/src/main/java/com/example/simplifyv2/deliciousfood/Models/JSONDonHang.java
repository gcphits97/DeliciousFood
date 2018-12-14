package com.example.simplifyv2.deliciousfood.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONDonHang {
    public List<DonHangModel> ParserJSONDonHang(String jsondata) {
        List<DonHangModel> donHangModelList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsondata);
            JSONArray jsonArray = jsonObject.getJSONArray("donhang");
            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject value = jsonArray.getJSONObject(i);
                DonHangModel donHangModel = new DonHangModel();

                donHangModel.setId_donhang(value.getInt("id_donhang"));
                donHangModel.setId_khachhang(value.getInt("id_khachhang"));
                donHangModel.setId_monan(value.getInt("id_monan"));
                donHangModel.setSoluong(value.getInt("soluong"));
                donHangModel.setTongtien(value.getInt("tongtien"));
                donHangModel.setGiaban(value.getInt("giaban"));
                donHangModel.setTenmonan(value.getString("tenmonan"));
                donHangModel.setHinhanhmonan(value.getString("hinhanhmonan"));
                donHangModel.setMotamonan(value.getString("motamonan"));

                donHangModelList.add(donHangModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return donHangModelList;
    }
}
