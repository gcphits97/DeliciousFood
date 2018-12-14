package com.example.simplifyv2.deliciousfood.Presenters;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public interface ImpCartDetail {
    void setEventDelete(ImageButton imageButtonMinus, TextView txtSoLuong, int soluong, int id_donhang);
    void setEventSaveToCart(String id_donhang, String soluong, String tongtien);
    void setEventClickBook(View dialogViewBook);
    void setEventClickDelivery(View dialogViewDelivery);
    void showCartDetail(int id_donhang);
}
