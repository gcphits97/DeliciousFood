package com.example.simplifyv2.deliciousfood.View;

public interface ViewCartDetail {
    void DeleteSuccessfully();
    void DeleteFail();
    void SaveSuccessfully();
    void SaveFail();
    void BookSuccessfully(int i, String hinhthucdonhang, String hinhthucthanhtoan, String thoigian);
    void BookFail();
    void DeliverySuccessfully();
    void DeliveryFail();
    void ShowInfoCartDetail(int soluong, int tongtien, String hinhthucdonhang, String diachigiaohang, String hinhthucthanhtoan, String thoigian);
    void CartDetailHaveNotData();
}
