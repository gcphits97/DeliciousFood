package com.example.simplifyv2.deliciousfood.View.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.View.LoginActivity;
import com.example.simplifyv2.deliciousfood.View.PaymentActivity;
import com.example.simplifyv2.deliciousfood.R;
import com.example.simplifyv2.deliciousfood.View.ProfileActivity;
import com.example.simplifyv2.deliciousfood.View.SearchViewActivity;

public class AccountFragment extends Fragment implements View.OnClickListener {
    private TextView txtVersionFragmentAccount, txtPayment, txtLogin, txtViewProfile, txtLogOut, txtName, txtEmail;
    private static final int flags = 1;
    LinearLayout frameLogin, frameViewProfile;
    SharedPreferences recived;
    ImageButton imageButtonSearch;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        txtVersionFragmentAccount = view.findViewById(R.id.txtVersionFragmentAccount);
        txtPayment = view.findViewById(R.id.txtPayment);
        txtLogin = view.findViewById(R.id.txtLogin);
        frameLogin = view.findViewById(R.id.frameLogin);
        frameViewProfile = view.findViewById(R.id.frameViewProfile);
        txtViewProfile = view.findViewById(R.id.txtViewProfile);
        txtLogOut = view.findViewById(R.id.txtLogOut);
        txtName = view.findViewById(R.id.txtName);
        txtEmail = view.findViewById(R.id.txtEmail);
        imageButtonSearch = view.findViewById(R.id.imageButtonSearch);
        //lấy version ứng dụng
        try {
            @SuppressLint("WrongConstant")
            String version = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), flags).versionName;
            txtVersionFragmentAccount.setText("Version"+" "+version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //bắt sự kiện click chuột
        txtPayment.setOnClickListener(this);
        txtLogin.setOnClickListener(this);
        txtViewProfile.setOnClickListener(this);
        txtLogOut.setOnClickListener(this);
        imageButtonSearch.setOnClickListener(this);
        return view;
    }

    public void getDataUser() {
        recived = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        if (recived.getString("username", null) != null) {
            String name = recived.getString("name", null);
            String email = recived.getString("email", null);
            frameLogin.setVisibility(View.GONE);
            frameViewProfile.setVisibility(View.VISIBLE);
            txtName.setText(name);
            txtEmail.setText(email);
        } else {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDataUser();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtLogin:
                Intent iLogin = new Intent(getContext(), LoginActivity.class);
                startActivity(iLogin);
                break;
            case R.id.txtViewProfile:
                Intent iProfile = new Intent(getContext(), ProfileActivity.class);
                startActivity(iProfile);
                break;
            case R.id.imageButtonSearch:
                Intent iSearch = new Intent(getContext(), SearchViewActivity.class);
                startActivity(iSearch);
                break;
            case R.id.txtPayment:
                Intent iPayment = new Intent(getContext(), PaymentActivity.class);
                startActivity(iPayment);
                break;
            case R.id.txtInviteFriends:
                Intent iInviteFriends = new Intent(getContext(), PaymentActivity.class);
                startActivity(iInviteFriends);
                break;
            case R.id.txtFeedback:
                Intent iFeedback = new Intent(getContext(), PaymentActivity.class);
                startActivity(iFeedback);
                break;
            case R.id.txtSettings:
                Intent iSettings = new Intent(getContext(), PaymentActivity.class);
                startActivity(iSettings);
                break;
            case R.id.txtHelp:
                Intent iHelp = new Intent(getContext(), PaymentActivity.class);
                startActivity(iHelp);
                break;
            case R.id.txtAbout:
                Intent iAbout = new Intent(getContext(), PaymentActivity.class);
                startActivity(iAbout);
                break;
            case R.id.txtLogOut:
                recived.edit().clear().commit();
                getActivity().getSupportFragmentManager().beginTransaction().detach(this).attach(this).commit();
                break;
        }
    }
}
