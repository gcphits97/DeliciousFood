package com.example.simplifyv2.deliciousfood.Models;

public class ChiTietMonAnModel {
    int id_chitietmonan, id_khachhang, id_monan, ulike, ushare;

    public ChiTietMonAnModel() {
    }

    public ChiTietMonAnModel(int id_chitietmonan, int id_khachhang, int id_monan, int ulike, int ushare) {
        this.id_chitietmonan = id_chitietmonan;
        this.id_khachhang = id_khachhang;
        this.id_monan = id_monan;
        this.ulike = ulike;
        this.ushare = ushare;
    }

    public int getId_chitietmonan() {
        return id_chitietmonan;
    }

    public void setId_chitietmonan(int id_chitietmonan) {
        this.id_chitietmonan = id_chitietmonan;
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

    public int getUlike() {
        return ulike;
    }

    public void setUlike(int ulike) {
        this.ulike = ulike;
    }

    public int getUshare() {
        return ushare;
    }

    public void setUshare(int ushare) {
        this.ushare = ushare;
    }
}
