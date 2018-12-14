package com.example.simplifyv2.deliciousfood.Models;

public class DonHangModel {
    int id_donhang, id_khachhang, soluong, tongtien, id_monan, giaban;
    String tenmonan, hinhanhmonan, motamonan;

    public DonHangModel() {
    }

    public DonHangModel(int id_donhang, int id_khachhang, int soluong, int tongtien, int id_monan, int giaban, String tenmonan, String hinhanhmonan, String motamonan) {
        this.id_donhang = id_donhang;
        this.id_khachhang = id_khachhang;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.id_monan = id_monan;
        this.giaban = giaban;
        this.tenmonan = tenmonan;
        this.hinhanhmonan = hinhanhmonan;
        this.motamonan = motamonan;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getId_monan() {
        return id_monan;
    }

    public void setId_monan(int id_monan) {
        this.id_monan = id_monan;
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public String getHinhanhmonan() {
        return hinhanhmonan;
    }

    public void setHinhanhmonan(String hinhanhmonan) {
        this.hinhanhmonan = hinhanhmonan;
    }

    public String getMotamonan() {
        return motamonan;
    }

    public void setMotamonan(String motamonan) {
        this.motamonan = motamonan;
    }
}
