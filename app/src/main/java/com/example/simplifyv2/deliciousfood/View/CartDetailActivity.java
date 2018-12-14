package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplifyv2.deliciousfood.Presenters.PresenterCartDetailActivity;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.Path;
import com.example.simplifyv2.deliciousfood.View.Fragments.CartFragment;
import com.squareup.picasso.Picasso;

public class CartDetailActivity extends AppCompatActivity implements View.OnClickListener, ViewCartDetail {
    Toolbar toolbar_detail_activity;
    TextView txtTenMonAn, txtGiaBan, txtMoTa, txtSoLuong, txtTongTien, txtDelete, txtTitle
            , txtSoLuongInfo, txtTongTienInfo, txtHinhThucDonHang, txtHinhThucThanhToan, txtThoiGianDatBan;
    ImageButton imageButtonMinus, imageButtonAdd;
    Button btnSaveToCart, btnDelivery, btnBook;
    private int soluong, tongtien, id_donhang, giaban, soluongbandau;
    ImageView imageViewDetail, imageBack;
    LinearLayout linearLayoutDeliveryAndBook, linearLayoutSave, linearLayoutBook;
    Path path;
    PresenterCartDetailActivity presenterCartDetailActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);

        toolbar_detail_activity = findViewById(R.id.toolbar_detail_activity);
        txtTenMonAn = findViewById(R.id.txtTenMonAn);
        txtGiaBan = findViewById(R.id.txtGiaBan);
        txtMoTa = findViewById(R.id.txtMoTa);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtTongTien = findViewById(R.id.txtTongTien);
        txtDelete = findViewById(R.id.txtDelete);
        txtTitle = findViewById(R.id.txtTitle);
        imageButtonMinus = findViewById(R.id.imageButtonMinus);
        imageButtonAdd = findViewById(R.id.imageButtonAdd);
        btnSaveToCart = findViewById(R.id.btnSaveToCart);
        btnDelivery = findViewById(R.id.btnDelivery);
        btnBook = findViewById(R.id.btnBook);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        imageBack = findViewById(R.id.imageBack);
        linearLayoutDeliveryAndBook = findViewById(R.id.linearLayoutDeliveryAndBook);
        linearLayoutSave = findViewById(R.id.linearLayoutSave);
        linearLayoutBook = findViewById(R.id.linearLayoutBook);
        txtSoLuongInfo = findViewById(R.id.txtSoLuongInfo);
        txtTongTienInfo = findViewById(R.id.txtTongTienInfo);
        txtHinhThucDonHang = findViewById(R.id.txtHinhThucDonHang);
        txtHinhThucThanhToan = findViewById(R.id.txtHinhThucThanhToan);
        txtThoiGianDatBan = findViewById(R.id.txtThoiGianDatBan);

        String tenmonan = getIntent().getStringExtra("tenmonan");
        String mota = getIntent().getStringExtra("mota");
        String hinhanh = getIntent().getStringExtra("hinhanh");
        soluong = getIntent().getIntExtra("soluong", 0);
        giaban = getIntent().getIntExtra("giaban", 0);
        tongtien = getIntent().getIntExtra("tongtien", 0);
        id_donhang = getIntent().getIntExtra("id_donhang", 0);
        soluongbandau = soluong;

        path = new Path();
        presenterCartDetailActivity = new PresenterCartDetailActivity(this, id_donhang);

        txtTenMonAn.setText(tenmonan);
        txtMoTa.setText(mota);
        txtGiaBan.setText(giaban+"vnđ");
        txtSoLuong.setText(soluong+"");
        txtTongTien.setText(tongtien+"vnđ");
        txtTitle.setText(tenmonan);
        ShowImage(hinhanh);

        imageBack.setOnClickListener(this);
        txtDelete.setOnClickListener(this);

        presenterCartDetailActivity.showCartDetail(id_donhang);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButtonMinus:
                linearLayoutDeliveryAndBook.setVisibility(View.GONE);
                int sl2 = Integer.parseInt(txtSoLuong.getText().toString());
                if (sl2 > 0) {
                    sl2 = sl2 - 1;
                    tongtien = sl2 * giaban;
                    txtSoLuong.setText(sl2+"");
                    txtTongTien.setText(tongtien+"vnđ");
                    if (sl2 == 0) {
                        imageButtonMinus.setVisibility(View.GONE);
                        presenterCartDetailActivity.setEventDelete(imageButtonMinus, txtSoLuong, soluongbandau, id_donhang);
                    }
                }
                break;
            case R.id.imageButtonAdd:
                linearLayoutDeliveryAndBook.setVisibility(View.GONE);
                int sl1 = Integer.parseInt(txtSoLuong.getText().toString());
                sl1 = sl1 + 1;
                tongtien = sl1 * giaban;
                txtSoLuong.setText(sl1+"");
                txtTongTien.setText(tongtien+"vnđ");
                break;
            case R.id.btnSaveToCart:
                int soluongsau = Integer.parseInt(txtSoLuong.getText().toString());
                if (soluongbandau != soluongsau) {
                    soluongbandau = soluongsau;
                    presenterCartDetailActivity.setEventSaveToCart(String.valueOf(id_donhang), txtSoLuong.getText().toString(), txtTongTien.getText().toString());
                }
                break;
            case R.id.btnBook:
                View dialogViewBook = getLayoutInflater().inflate(R.layout.alert_dialog_book_in_cart, null);
                presenterCartDetailActivity.setEventClickBook(dialogViewBook);
                break;
            case R.id.btnDelivery:
                View dialogViewDelivery = getLayoutInflater().inflate(R.layout.alert_dialog_delivery_in_cart, null);
                presenterCartDetailActivity.setEventClickDelivery(dialogViewDelivery);
                break;
            case R.id.imageBack:
                onBackPressed();
                break;
            case R.id.txtDelete:
                presenterCartDetailActivity.setEventDelete(imageButtonMinus, txtSoLuong, soluongbandau, id_donhang);
                break;
        }
    }

    public void ShowImage(String hinhanh) {
        Picasso.get().load(hinhanh)
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(imageViewDetail);
    }

    @Override
    public void DeleteSuccessfully() {
        finish();
        getSupportFragmentManager().beginTransaction().detach(new CartFragment()).attach(new CartFragment()).commit();
        Toast.makeText(getApplicationContext(), "Delete Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DeleteFail() {
        Toast.makeText(getApplicationContext(), "Delete Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SaveSuccessfully() {
        linearLayoutDeliveryAndBook.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), "Save Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SaveFail() {
        Toast.makeText(getApplicationContext(), "Save Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void BookSuccessfully(int i, String hinhthucdonhang, String hinhthucthanhtoan, String thoigian) {
        if (i == 0) {
            Toast.makeText(this, "Lien ket tai khoan thanh cong", Toast.LENGTH_SHORT).show();
        } else {
            linearLayoutDeliveryAndBook.setVisibility(View.GONE);
            linearLayoutSave.setVisibility(View.GONE);

            linearLayoutBook.setVisibility(View.VISIBLE);
            txtSoLuongInfo.setText(txtSoLuong.getText().toString());
            txtTongTien.setText(txtSoLuong.getText().toString());
            txtHinhThucDonHang.setText(hinhthucdonhang);
            txtHinhThucThanhToan.setText(hinhthucthanhtoan);
            txtThoiGianDatBan.setText(thoigian);
            Toast.makeText(this, "Dat ban thanh cong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void BookFail() {
        Toast.makeText(this, "Dat ban that bai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DeliverySuccessfully() {

    }

    @Override
    public void DeliveryFail() {

    }

    @Override
    public void ShowInfoCartDetail(String hinhthucdonhang, String diachigiaohang, String hinhthucthanhtoan, String thoigian) {
        linearLayoutDeliveryAndBook.setVisibility(View.GONE);
        linearLayoutSave.setVisibility(View.GONE);
        if (diachigiaohang != null) {

        } else {
            linearLayoutBook.setVisibility(View.VISIBLE);
            txtSoLuongInfo.setText(txtSoLuong.getText().toString());
            txtTongTien.setText(txtSoLuong.getText().toString());
            txtHinhThucDonHang.setText(hinhthucdonhang);
            txtHinhThucThanhToan.setText(hinhthucthanhtoan);
            txtThoiGianDatBan.setText(thoigian);
        }
    }

    @Override
    public void CartDetailHaveNotData() {
        imageButtonMinus.setOnClickListener(this);
        imageButtonAdd.setOnClickListener(this);
        btnSaveToCart.setOnClickListener(this);
        btnBook.setOnClickListener(this);
        btnDelivery.setOnClickListener(this);
    }
}
