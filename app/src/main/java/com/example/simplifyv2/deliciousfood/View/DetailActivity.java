package com.example.simplifyv2.deliciousfood.View;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplifyv2.deliciousfood.View.Fragments.CartFragment;
import com.example.simplifyv2.deliciousfood.Presenters.PresenterDetail;
import com.example.simplifyv2.deliciousfood.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener, ViewDetail {
    Toolbar toolbar_detail_activity;
    TextView txtTitle, txtTenMonAn, txtMoTa, txtGiaBan, txtSoLuong, txtTongTien;
    ImageView imageBack, imageViewDetail;
    Button btnAddToCart, btnLike, btnShare;
    PresenterDetail presenterDetail;
    ImageButton imageButtonMinus, imageButtonAdd;
    String ten, giaban, hinhanh, mota;
    private int id_monan, id_khachhang, tongtien;
    SharedPreferences recived;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ten = getIntent().getStringExtra("ten");
        mota = getIntent().getStringExtra("mota");
        giaban = getIntent().getStringExtra("giaban");
        hinhanh = getIntent().getStringExtra("hinhanh");
        id_monan = getIntent().getIntExtra("id_monan", 0);
        recived = getSharedPreferences("user", MODE_PRIVATE);
        id_khachhang = recived.getInt("id", 0);

        toolbar_detail_activity = findViewById(R.id.toolbar_detail_activity);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtTongTien = findViewById(R.id.txtTongTien);
        imageButtonMinus = findViewById(R.id.imageButtonMinus);
        imageButtonAdd = findViewById(R.id.imageButtonAdd);
        txtTitle = findViewById(R.id.txtTitle);
        imageBack = findViewById(R.id.imageBack);
        txtTenMonAn = findViewById(R.id.txtTenMonAn);
        txtMoTa = findViewById(R.id.txtMoTa);
        txtGiaBan = findViewById(R.id.txtGiaBan);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnLike = findViewById(R.id.btnLike);
        btnShare = findViewById(R.id.btnShare);

        toolbar_detail_activity.setTitle("");
        setSupportActionBar(toolbar_detail_activity);
        txtTitle.setText(R.string.title_detail_activity);
        imageBack.setOnClickListener(this);

        txtTenMonAn.setText(ten);
        txtMoTa.setText(mota);
        txtGiaBan.setText(giaban+"vnđ");
        txtSoLuong.setText("0");
        imageButtonMinus.setVisibility(View.GONE);
        DownloadImageBitmapFromURL(hinhanh, imageViewDetail);

        presenterDetail = new PresenterDetail(this);
        presenterDetail.getDataToShowLike(id_monan, id_khachhang);
        presenterDetail.getDataToShowShare(id_monan, id_khachhang);

        btnAddToCart.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        imageButtonMinus.setOnClickListener(this);
        imageButtonAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBack:
                onBackPressed();
                break;
            case R.id.btnAddToCart:
                if (id_khachhang != 0) {
                    int soluong = Integer.parseInt(txtSoLuong.getText().toString());
                    if (soluong > 0) {
                        presenterDetail.setEventAddtoCart(id_monan, soluong, tongtien, id_khachhang);
                        getSupportFragmentManager().beginTransaction().detach(new CartFragment()).attach(new CartFragment()).commit();
                    } else {
                        Toast.makeText(this, getText(R.string.amount_not_zero), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, getText(R.string.must_login), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLike:
                break;
            case R.id.btnShare:
                break;
            case R.id.imageButtonMinus:
                int sl2 = Integer.parseInt(txtSoLuong.getText().toString());
                if (sl2 > 0) {
                    sl2 = sl2 - 1;
                    tongtien = sl2 * Integer.parseInt(giaban);
                    txtSoLuong.setText(sl2+"");
                    txtTongTien.setText(tongtien+"vnđ");
                    if (sl2 == 0) {
                        imageButtonMinus.setVisibility(View.GONE);
                    }
                }
                break;
            case R.id.imageButtonAdd:
                int sl1 = Integer.parseInt(txtSoLuong.getText().toString());
                sl1 = sl1 + 1;
                imageButtonMinus.setVisibility(View.VISIBLE);
                tongtien = sl1 * Integer.parseInt(giaban);
                txtSoLuong.setText(sl1+"");
                txtTongTien.setText(tongtien+"vnđ");
                break;
        }
    }
    private void DownloadImageBitmapFromURL(String hinhanh, ImageView imageViewDetail) {
        Picasso.get().load(hinhanh)
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(imageViewDetail);
    }

    @Override
    public void InsertSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InsertFail() {
        Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void CheckLike(boolean checkLike, int countLike) {
        if (checkLike == true) {
            btnLike.setBackground(getDrawable(R.drawable.custom_button_in_detail_activity));
            btnLike.setText(String.valueOf(countLike));
        } else {
            btnLike.setText(String.valueOf(countLike));
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void CheckShare(boolean checkShare, int countShare) {
        if (checkShare == true) {
            btnShare.setBackground(getDrawable(R.drawable.custom_button_in_detail_activity));
            btnShare.setText(String.valueOf(countShare));
        } else {
            btnShare.setText(String.valueOf(countShare));
        }
    }
}
