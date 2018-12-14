package com.example.simplifyv2.deliciousfood.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONUser {
    public List<UserModel> ParseJSONUser(String datajson) {
        List<UserModel> userModelList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(datajson);
            JSONArray jsonArray = jsonObject.getJSONArray("khachhang");
            int count = jsonArray.length();
            for (int i = 0; i < count; i++) {
                JSONObject dataUser = jsonArray.getJSONObject(i);

                UserModel userModel = new UserModel();
                userModel.setId_khachhang(dataUser.getInt("id_khachhang"));
                userModel.setHoten(dataUser.getString("hoten"));
                userModel.setDiachi(dataUser.getString("diachi"));
                userModel.setSdt(dataUser.getString("sdt"));
                userModel.setTendangnhap(dataUser.getString("tendangnhap"));
                userModel.setMatkhau(dataUser.getString("matkhau"));
                userModel.setEmail(dataUser.getString("email"));
                userModel.setAvatar(dataUser.getString("avatar"));

                userModelList.add(userModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userModelList;
    }
}
