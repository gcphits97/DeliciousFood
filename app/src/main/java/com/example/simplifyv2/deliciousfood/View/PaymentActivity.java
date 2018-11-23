package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar_payment_activity;
    TextView txtTitle;
    ImageView imageBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //ánh xạ
        toolbar_payment_activity = findViewById(R.id.toolbar_payment_activity);
        txtTitle = findViewById(R.id.txtTitle);
        imageBack = findViewById(R.id.imageBack);
        //set up toolbar
        toolbar_payment_activity.setTitle("");
        setSupportActionBar(toolbar_payment_activity);
        txtTitle.setText(R.string.title_payment_activity);
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
