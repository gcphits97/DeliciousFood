package com.example.simplifyv2.deliciousfood.View;

public interface ViewLogin {
    void LoginSuccess(int id, String name, String address, String phonenumber,
                      String username, String password, String email, String avatar);
    void LoginFail();
}
