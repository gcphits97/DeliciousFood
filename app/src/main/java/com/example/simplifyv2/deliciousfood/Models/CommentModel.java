package com.example.simplifyv2.deliciousfood.Models;

import java.util.List;

public class CommentModel {
    int id_binhluan, id_khachhang, id_monan, like;
    String noidung;
    List<String> hinhanh;
    List<UserModel> userModelList;

    public CommentModel() {
    }

    public CommentModel(int id_binhluan, int id_khachhang, int id_monan, int like, String noidung, List<String> hinhanh, List<UserModel> userModelList, List<HomeModel> homeModelList) {
        this.id_binhluan = id_binhluan;
        this.id_khachhang = id_khachhang;
        this.id_monan = id_monan;
        this.like = like;
        this.noidung = noidung;
        this.hinhanh = hinhanh;
        this.userModelList = userModelList;
        this.homeModelList = homeModelList;
    }

    List<HomeModel> homeModelList;

    public List<UserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    public List<HomeModel> getHomeModelList() {
        return homeModelList;
    }

    public void setHomeModelList(List<HomeModel> homeModelList) {
        this.homeModelList = homeModelList;
    }

    public int getId_binhluan() {

        return id_binhluan;
    }

    public void setId_binhluan(int id_binhluan) {
        this.id_binhluan = id_binhluan;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public int getId_monan() {
        return id_monan;
    }

    public void setId_monan(int id_monan) {
        this.id_monan = id_monan;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public List<String> getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(List<String> hinhanh) {
        this.hinhanh = hinhanh;
    }
}
