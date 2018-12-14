package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplifyv2.deliciousfood.Presenters.PresenterLogicRegister;
import com.example.simplifyv2.deliciousfood.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, ViewRegister {
    TextView txtLogin;
    EditText edtName, edtUserName, edtPassword, edtReEnterPassword, edtEmail;
    Button btnRegister;
    PresenterLogicRegister presenterLogicRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtLogin = findViewById(R.id.txtLogin);
        edtName = findViewById(R.id.edtNameRegister);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtReEnterPassword = findViewById(R.id.edtReEnterPassword);
        edtEmail = findViewById(R.id.edtEmailRegister);
        btnRegister = findViewById(R.id.btnRegister);

        txtLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        presenterLogicRegister = new PresenterLogicRegister(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtLogin:
                Intent iLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(iLogin);
                finish();
                break;
            case R.id.btnRegister:
                String name = edtName.getText().toString();
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                String repassword = edtReEnterPassword.getText().toString();
                String email = edtEmail.getText().toString();
                presenterLogicRegister.setCheckRegister(name, username, password, email, repassword);
                break;
        }
    }

    @Override
    public void RegisterSuccess() {
        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegisterFail(int error) {
        Toast.makeText(RegisterActivity.this, getText(error), Toast.LENGTH_LONG).show();
    }
}
