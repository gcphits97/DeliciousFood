package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar_detail_activity;
    TextView txtTitle;
    ImageView imageBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        toolbar_detail_activity = findViewById(R.id.toolbar_detail_activity);
        txtTitle = findViewById(R.id.txtTitle);
        imageBack = findViewById(R.id.imageBack);

        toolbar_detail_activity.setTitle("");
        setSupportActionBar(toolbar_detail_activity);
        txtTitle.setText(R.string.title_detail_activity);
        imageBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBack:
                onBackPressed();
                break;
        }
    }
}
