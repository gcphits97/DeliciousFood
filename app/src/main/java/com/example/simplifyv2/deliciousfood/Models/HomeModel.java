package com.example.simplifyv2.deliciousfood.Models;

public class HomeModel {
    int id_monan;
    int id_loaimoanan;
    String tenmonan;
    String hinhanhmonan;
    String motamonan;
    int giaban;

    public HomeModel() {
    }

    public HomeModel(int id_monan, int id_loaimoanan, String tenmonan, String hinhanhmonan, String motamonan, int giaban) {

        this.id_monan = id_monan;
        this.id_loaimoanan = id_loaimoanan;
        this.tenmonan = tenmonan;
        this.hinhanhmonan = hinhanhmonan;
        this.motamonan = motamonan;
        this.giaban = giaban;
    }

    public int getId_monan() {

        return id_monan;
    }

    public void setId_monan(int id_monan) {
        this.id_monan = id_monan;
    }

    public int getId_loaimoanan() {
        return id_loaimoanan;
    }

    public void setId_loaimoanan(int id_loaimoanan) {
        this.id_loaimoanan = id_loaimoanan;
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

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
}
