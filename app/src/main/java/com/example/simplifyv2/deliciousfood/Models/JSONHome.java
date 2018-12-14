package com.example.simplifyv2.deliciousfood.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONHome {
    public List<HomeModel> ParserJSONHome(String datajson) {
        List<HomeModel> homeModelList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(datajson);
            JSONArray jsonArray = jsonObject.getJSONArray("monan");
            int count = jsonArray.length();
            for (int i = 0; i < count;i++) {
                JSONObject value = jsonArray.getJSONObject(i);

                HomeModel datafastFood = new HomeModel();

                datafastFood.setId_monan(value.getInt("id_monan"));
                datafastFood.setTenmonan(value.getString("tenmonan"));
                datafastFood.setHinhanhmonan(value.getString("hinhanhmonan"));
                datafastFood.setMotamonan(value.getString("motamonan"));
                datafastFood.setGiaban(value.getInt("giaban"));
                datafastFood.setId_loaimoanan(value.getInt("id_loaimonan"));

                homeModelList.add(datafastFood);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return homeModelList;
    }
}
