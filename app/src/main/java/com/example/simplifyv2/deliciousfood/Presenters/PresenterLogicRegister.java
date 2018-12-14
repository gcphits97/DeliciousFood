package com.example.simplifyv2.deliciousfood.Presenters;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.simplifyv2.deliciousfood.Models.JSONUser;
import com.example.simplifyv2.deliciousfood.Models.UserModel;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.DownloadJSONUser;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.ViewRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PresenterLogicRegister implements ImpRegister {
    ViewRegister viewRegister;
    Path path;

    public PresenterLogicRegister(ViewRegister viewRegister) {
        this.viewRegister = viewRegister;
        path = new Path();
    }

    @Override
    public void setCheckRegister(String name, String username, String password, String email, String repassword) {
        final List<UserModel> userModelList;
        String data = "";
        boolean check = true;

        DownloadJSONUser downloadJSONUser = new DownloadJSONUser(path.getPath_khachhang());
        downloadJSONUser.execute();

        try {
            data = downloadJSONUser.get();
            JSONUser jsonUser = new JSONUser();
            userModelList = jsonUser.ParseJSONUser(data);
            for (UserModel value: userModelList) {
                if (username.equalsIgnoreCase(value.getTendangnhap())) {
                    viewRegister.RegisterFail(R.string.error_username_isexist);
                    check = false;
                }
            }
            if (name.trim().isEmpty() || email.trim().isEmpty() || username.trim().isEmpty()) {
                viewRegister.RegisterFail(R.string.error_isemty);
                check = false;
            } else if (password.trim().length() < 8) {
                viewRegister.RegisterFail(R.string.error_password_so_short);
                check = false;
            } else if (!repassword.equalsIgnoreCase(password)) {
                viewRegister.RegisterFail(R.string.error_re_enter_password);
                check = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.trim().toString()).matches()) {
                viewRegister.RegisterFail(R.string.error_email);
                check = false;
            }
            if (check == true) {
                setActionRegister(name, username, password, email);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setActionRegister(final String name, final String username, final String password, final String email) {
        RequestQueue queue = Volley.newRequestQueue((Context) viewRegister);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_khachhang_insert(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    viewRegister.RegisterSuccess();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsInsert = new HashMap<>();
                hsInsert.put("hoten", name);
                hsInsert.put("tendangnhap", username);
                hsInsert.put("matkhau", password);
                hsInsert.put("email", email);
                return hsInsert;
            }
        };
        queue.add(request);
    }
}
