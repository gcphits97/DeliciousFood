package com.example.simplifyv2.deliciousfood.View;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.R;

public class SplashScreenActivity extends AppCompatActivity {
    private TextView txtVersionSplashScreen;
    private static final int flags = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        txtVersionSplashScreen = findViewById(R.id.txtVersionSplashScreen);
        Thread thread = new Thread() {
            public void run() {
                try {
                    //get version app
                    PackageInfo packageInfo = getApplication().getPackageManager().getPackageInfo(getPackageName(),flags);
                    String version = packageInfo.versionName;
                    txtVersionSplashScreen.setText("Version"+" "+version);
                    //set time splash screen
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    Intent home = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }
            }
        };
        thread.start();
    }
}