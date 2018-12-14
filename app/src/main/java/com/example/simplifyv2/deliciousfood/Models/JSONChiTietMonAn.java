package com.example.simplifyv2.deliciousfood.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONChiTietMonAn {
    public List<ChiTietMonAnModel> ParseJSONChiTietMonAn(String datajson) {
        List<ChiTietMonAnModel> chiTietMonAnModelList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(datajson);
            JSONArray jsonArray = jsonObject.getJSONArray("chitietmonan");
            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject value = jsonArray.getJSONObject(i);
                ChiTietMonAnModel chiTietMonAnModel = new ChiTietMonAnModel();
                chiTietMonAnModel.setId_chitietmonan(value.getInt("id_chitietmonan"));
                chiTietMonAnModel.setId_khachhang(value.getInt("id_khachhang"));
                chiTietMonAnModel.setId_monan(value.getInt("id_monan"));
                chiTietMonAnModel.setUlike(value.getInt("ulike"));
                chiTietMonAnModel.setUshare(value.getInt("ushare"));

                chiTietMonAnModelList.add(chiTietMonAnModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return chiTietMonAnModelList;
    }
}
