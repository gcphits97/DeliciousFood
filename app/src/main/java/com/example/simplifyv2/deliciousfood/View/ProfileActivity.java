package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.Server.Path;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtName, txtAddress, txtPhone, txtEmail, txtTitle, txtChangeProfile, txtSaveProfile;
    ImageView imageBack;
    EditText edtChangeName, edtChangeAddress, edtChangePhone, edtChangeEmail;
    Toolbar toolbarProfile;
    String name, address, phonenumber, email;
    int id;
    SharedPreferences recived;
    Path path;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtName = findViewById(R.id.txtNameProfile);
        txtAddress = findViewById(R.id.txtAddressProfile);
        txtPhone = findViewById(R.id.txtPhoneNumberProfile);
        txtEmail = findViewById(R.id.txtEmailProfile);
        txtChangeProfile = findViewById(R.id.txtChangeProfile);
        txtSaveProfile = findViewById(R.id.txtSaveProfile);
        toolbarProfile = findViewById(R.id.toolbarProfile);
        txtTitle = findViewById(R.id.txtTitleProfile);
        imageBack = findViewById(R.id.imageBackProfile);
        edtChangeName = findViewById(R.id.edtChangeName);
        edtChangeAddress = findViewById(R.id.edtChangeAddress);
        edtChangePhone = findViewById(R.id.edtChangePhone);
        edtChangeEmail = findViewById(R.id.edtChangeEmail);

        path = new Path();
        //toolbar
        setSupportActionBar(toolbarProfile);
        toolbarProfile.setTitle("");
        txtTitle.setText(R.string.title_profile_activity);
        imageBack.setOnClickListener(this);
        //end toolbar

        setDataUserProfile();

        txtChangeProfile.setOnClickListener(this);
        txtSaveProfile.setOnClickListener(this);
    }

    public void setDataUserProfile() {
        recived = getSharedPreferences("user", MODE_PRIVATE);
        id = recived.getInt("id", 0);
        String avatar = recived.getString("avatar", null);
        String username = recived.getString("username", null);
        String password = recived.getString("password", null);
        name = recived.getString("name", null);
        address = recived.getString("address", null);
        phonenumber = recived.getString("phonenumber", null);
        email = recived.getString("email", null);
        txtName.setText(name);
        txtAddress.setText(address);
        txtPhone.setText(phonenumber);
        txtEmail.setText(email);
        edtChangeName.setText(name);
        edtChangeAddress.setText(address);
        edtChangePhone.setText(phonenumber);
        edtChangeEmail.setText(email);
    }

    public void setChangeProfile() {
        txtName.setVisibility(View.GONE);
        txtAddress.setVisibility(View.GONE);
        txtPhone.setVisibility(View.GONE);
        txtEmail.setVisibility(View.GONE);
        txtChangeProfile.setVisibility(View.GONE);

        edtChangeName.setVisibility(View.VISIBLE);
        edtChangeAddress.setVisibility(View.VISIBLE);
        edtChangePhone.setVisibility(View.VISIBLE);
        edtChangeEmail.setVisibility(View.VISIBLE);
        txtSaveProfile.setVisibility(View.VISIBLE);
    }

    public void setSaveProfile() {
        name = edtChangeName.getText().toString();
        address = edtChangeAddress.getText().toString();
        phonenumber = edtChangePhone.getText().toString();
        email = edtChangeEmail.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, path.getPath_update_profile(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("kiemtra", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hsUpdate = new HashMap<>();
                hsUpdate.put("id_khachhang", String.valueOf(id));
                hsUpdate.put("hoten", name);
                hsUpdate.put("diachi", address);
                hsUpdate.put("sdt", phonenumber);
                hsUpdate.put("email", email);
                return hsUpdate;
            }
        };
        queue.add(request);

        SharedPreferences.Editor editor = recived.edit();
        editor.putString("name", name);
        editor.putString("address", address);
        editor.putString("phonenumber", phonenumber);
        editor.putString("email", email);
        editor.apply();

        finish();
        startActivity(new Intent(ProfileActivity.this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBackProfile:
                onBackPressed();
                break;
            case R.id.txtChangeProfile:
                setChangeProfile();
                break;
            case R.id.txtSaveProfile:
                setSaveProfile();
                break;
        }
    }
}
