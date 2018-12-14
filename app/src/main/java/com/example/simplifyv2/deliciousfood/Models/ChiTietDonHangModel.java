package com.example.simplifyv2.deliciousfood.Models;

import java.util.Date;

public class ChiTietDonHangModel {
    int id_donhang, id_khachhang, id_hinhthucthanhtoan, id_chitietdonhang;
    String hoten, sdt, tenhinhthucthanhtoan, tenloaidonhang, diachigiaohang, thoigiangiaohang, thoigiandatban;

    public ChiTietDonHangModel() {
    }

    public ChiTietDonHangModel(int id_donhang, int id_khachhang, int id_hinhthucthanhtoan, int id_chitietdonhang
                                , String hoten, String sdt, String tenhinhthucthanhtoan, String tenloaidonhang
                                , String diachigiaohang, String thoigiangiaohang, String thoigiandatban) {
        this.id_donhang = id_donhang;
        this.id_khachhang = id_khachhang;
        this.id_hinhthucthanhtoan = id_hinhthucthanhtoan;
        this.id_chitietdonhang = id_chitietdonhang;
        this.hoten = hoten;
        this.sdt = sdt;
        this.tenhinhthucthanhtoan = tenhinhthucthanhtoan;
        this.tenloaidonhang = tenloaidonhang;
        this.diachigiaohang = diachigiaohang;
        this.thoigiangiaohang = thoigiangiaohang;
        this.thoigiandatban = thoigiandatban;
    }

    public int getId_chitietdonhang() {
        return id_chitietdonhang;
    }

    public void setId_chitietdonhang(int id_chitietdonhang) {
        this.id_chitietdonhang = id_chitietdonhang;
    }

    public int getId_hinhthucthanhtoan() {
        return id_hinhthucthanhtoan;
    }

    public void setId_hinhthucthanhtoan(int id_hinhthucthanhtoan) {
        this.id_hinhthucthanhtoan = id_hinhthucthanhtoan;
    }

    public int getId_donhang() {
        return id_donhang;
    }

    public void setId_donhang(int id_donhang) {
        this.id_donhang = id_donhang;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenhinhthucthanhtoan() {
        return tenhinhthucthanhtoan;
    }

    public void setTenhinhthucthanhtoan(String tenhinhthucthanhtoan) {
        this.tenhinhthucthanhtoan = tenhinhthucthanhtoan;
    }

    public String getTenloaidonhang() {
        return tenloaidonhang;
    }

    public void setTenloaidonhang(String tenloaidonhang) {
        this.tenloaidonhang = tenloaidonhang;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public String getThoigiangiaohang() {
        return thoigiangiaohang;
    }

    public void setThoigiangiaohang(String thoigiangiaohang) {
        this.thoigiangiaohang = thoigiangiaohang;
    }

    public String getThoigiandatban() {
        return thoigiandatban;
    }

    public void setThoigiandatban(String thoigiandatban) {
        this.thoigiandatban = thoigiandatban;
    }
}
