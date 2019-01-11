package com.example.simplifyv2.deliciousfood.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONChiTietDonHang {
    public List<ChiTietDonHangModel> ParseJSONChiTietDonHang(String jsondata) {
        List<ChiTietDonHangModel> chiTietDonHangModelList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsondata);
            JSONArray jsonArray = jsonObject.getJSONArray("chitietdonhang");

            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject value = jsonArray.getJSONObject(i);
                ChiTietDonHangModel chiTietDonHangModel = new ChiTietDonHangModel();
                chiTietDonHangModel.setId_donhang(value.getInt("id_donhang"));
                chiTietDonHangModel.setId_chitietdonhang(value.getInt("id_chitietdonhang"));
                chiTietDonHangModel.setId_khachhang(value.getInt("id_khachhang"));
                chiTietDonHangModel.setSoluong(value.getInt("soluong"));
                chiTietDonHangModel.setTongtien(value.getInt("tongtien"));
                chiTietDonHangModel.setHoten(value.getString("hoten"));
                chiTietDonHangModel.setSdt(value.getString("sdt"));
                chiTietDonHangModel.setTenhinhthucthanhtoan(value.getString("tenhinhthucthanhtoan"));
                chiTietDonHangModel.setTenloaidonhang(value.getString("tenloaidonhang"));
                chiTietDonHangModel.setDiachigiaohang(value.getString("diachigiaohang"));
                chiTietDonHangModel.setThoigiangiaohang(value.getString("thoigiangiaohang"));
                chiTietDonHangModel.setThoigiandatban(value.getString("thoigiandatban"));
                chiTietDonHangModel.setId_hinhthucthanhtoan(value.getInt("id_hinhthucthanhtoan"));

                chiTietDonHangModelList.add(chiTietDonHangModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return chiTietDonHangModelList;
    }
}
