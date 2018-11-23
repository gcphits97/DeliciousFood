package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtRegister = findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtRegister:
                Intent iRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(iRegister);
                break;
        }
    }
}
