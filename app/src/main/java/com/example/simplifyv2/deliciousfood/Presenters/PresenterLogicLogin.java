package com.example.simplifyv2.deliciousfood.Presenters;

import com.example.simplifyv2.deliciousfood.Models.JSONUser;
import com.example.simplifyv2.deliciousfood.Models.UserModel;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONUser;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.ViewLogin;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PresenterLogicLogin implements ImpLogin {
    ViewLogin viewLogin;
    Path path;

    public PresenterLogicLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        path = new Path();
    }

    @Override
    public void CheckLogin(String username, String password) {
        List<UserModel> userModelList;
        String data = "";
        boolean checkLogin = false;

        DownloadJSONUser downloadJSONUser = new DownloadJSONUser(path.getPath_khachhang());
        downloadJSONUser.execute();

        try {
            data = downloadJSONUser.get();
            JSONUser jsonUser = new JSONUser();
            userModelList = jsonUser.ParseJSONUser(data);
            for (UserModel userModel: userModelList) {
                if (username.equals(userModel.getTendangnhap()) && password.equals(userModel.getMatkhau())) {
                    viewLogin.LoginSuccess(userModel.getId_khachhang(), userModel.getHoten(), userModel.getDiachi(), userModel.getSdt(),
                            userModel.getTendangnhap(), userModel.getMatkhau(), userModel.getEmail(), userModel.getAvatar());
                    checkLogin = true;
                }
            }
            if (checkLogin == false) {
                viewLogin.LoginFail();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
