package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar_detail_activity;
    TextView txtTitle, txtTenMonAn, txtMoTa, txtGiaBan;
    ImageView imageBack, imageViewDetail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        String ten = getIntent().getStringExtra("ten");
        String mota = getIntent().getStringExtra("mota");
        String giaban = getIntent().getStringExtra("giaban");
        String hinhanh = getIntent().getStringExtra("hinhanh");

        toolbar_detail_activity = findViewById(R.id.toolbar_detail_activity);
        txtTitle = findViewById(R.id.txtTitle);
        imageBack = findViewById(R.id.imageBack);
        txtTenMonAn = findViewById(R.id.txtTenMonAn);
        txtMoTa = findViewById(R.id.txtMoTa);
        txtGiaBan = findViewById(R.id.txtGiaBan);
        imageViewDetail = findViewById(R.id.imageViewDetail);

        toolbar_detail_activity.setTitle("");
        setSupportActionBar(toolbar_detail_activity);
        txtTitle.setText(R.string.title_detail_activity);
        imageBack.setOnClickListener(this);

        txtTenMonAn.setText(ten);
        txtMoTa.setText(mota);
        txtGiaBan.setText(giaban+"vnđ");
        DownloadImageBitmapFromURL(hinhanh, imageViewDetail);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBack:
                onBackPressed();
                break;
        }
    }
    private void DownloadImageBitmapFromURL(String hinhanh, ImageView imageViewDetail) {
        Picasso.get().load(hinhanh)
                .placeholder(R.drawable.albedo)
                .error(R.mipmap.ic_error)
                .into(imageViewDetail);
    }
}
