package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplifyv2.deliciousfood.View.Fragments.AccountFragment;
import com.example.simplifyv2.deliciousfood.Presenters.PresenterLogicLogin;
import com.example.simplifyv2.deliciousfood.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ViewLogin {
    TextView txtRegister;
    EditText edtUserName, edtPassword;
    PresenterLogicLogin presenterLogicLogin;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtRegister = findViewById(R.id.txtRegister);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        txtRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        presenterLogicLogin = new PresenterLogicLogin(this);

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtRegister:
                Intent iRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(iRegister);
                finish();
                break;
            case R.id.btnLogin:
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                presenterLogicLogin.CheckLogin(username, password);
                break;
        }
    }

    @Override
    public void LoginSuccess(int id, String name, String address, String phonenumber, String username,
                             String password, String email, String avatar) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("id", id);
        editor.putString("name",name);
        editor.putString("address",address);
        editor.putString("phonenumber",phonenumber);
        editor.putString("username",username);
        editor.putString("password",password);
        editor.putString("email",email);
        editor.putString("avatar",avatar);

        editor.commit();
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().detach(new AccountFragment()).attach(new AccountFragment()).commit();
        onBackPressed();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Login fail", Toast.LENGTH_SHORT).show();
    }
}
