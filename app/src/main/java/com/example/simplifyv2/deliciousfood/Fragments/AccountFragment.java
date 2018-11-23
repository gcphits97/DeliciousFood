package com.example.simplifyv2.deliciousfood.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.View.LoginActivity;
import com.example.simplifyv2.deliciousfood.View.MainActivity;
import com.example.simplifyv2.deliciousfood.View.PaymentActivity;
import com.example.simplifyv2.deliciousfood.R;

public class AccountFragment extends Fragment implements View.OnClickListener {
    private TextView txtVersionFragmentAccount, txtPayment, txtOrderHistory, txtLogin;
    private static final int flags = 1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        txtVersionFragmentAccount = view.findViewById(R.id.txtVersionFragmentAccount);
        txtPayment = view.findViewById(R.id.txtPayment);
        txtOrderHistory = view.findViewById(R.id.txtOrderHistory);
        txtLogin = view.findViewById(R.id.txtLogin);
        try {
            @SuppressLint("WrongConstant")
            String version = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), flags).versionName;
            txtVersionFragmentAccount.setText("Version"+" "+version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        txtPayment.setOnClickListener(this);
        txtOrderHistory.setOnClickListener(this);
        txtLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
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
            case R.id.txtPayment:
                Intent iPayment = new Intent(getContext(), PaymentActivity.class);
                startActivity(iPayment);
                break;
            case R.id.txtOrderHistory:
//                BottomNavigationView navigationView = new BottomNavigationView(getActivity().getApplicationContext());
//                navigationView.getMenu().getItem(R.id.navigation_cart).setChecked(true);
//                Log.d("kiemtra", navigationView.getMenu().findItem(R.id.navigation_cart)+"");
//                FragmentTransaction ftCart = getActivity().getSupportFragmentManager().beginTransaction();
//                ftCart.replace(R.id.fragmentMain, new CartFragment(), "Cart Fragment");
//                ftCart.commit();
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
        }
    }
}
