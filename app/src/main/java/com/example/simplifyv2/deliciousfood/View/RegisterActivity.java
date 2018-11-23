package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtLogin:
                Intent iLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(iLogin);
                break;
        }
    }
}
