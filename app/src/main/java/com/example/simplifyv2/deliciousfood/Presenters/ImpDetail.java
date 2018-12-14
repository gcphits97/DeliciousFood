package com.example.simplifyv2.deliciousfood.Presenters;

public interface ImpDetail {
    void setEventAddtoCart(int id_monan, int soluong, int tongtien, int id_khachhang);
    void getDataToShowLike(int id_monan, int id_khachhang);
    void getDataToShowShare(int id_monan, int id_khachhang);
}
