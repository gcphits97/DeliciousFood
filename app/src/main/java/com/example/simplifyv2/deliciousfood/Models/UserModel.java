package com.example.simplifyv2.deliciousfood.Models;

public class UserModel {
    int id_khachhang;
    String hoten;
    String diachi;
    String sdt;
    String tendangnhap;
    String matkhau;
    String email;
    String avatar;

    public UserModel() {
    }

    public UserModel(int id_khachhang, String hoten, String diachi, String sdt, String tendangnhap, String matkhau, String email, String avatar) {
        this.id_khachhang = id_khachhang;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.email = email;
        this.avatar = avatar;
    }

    public int getId_khachhang() {

        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
