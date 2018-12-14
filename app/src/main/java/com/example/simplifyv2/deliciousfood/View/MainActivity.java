package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.simplifyv2.deliciousfood.View.Fragments.AccountFragment;
import com.example.simplifyv2.deliciousfood.View.Fragments.HomeFragment;
import com.example.simplifyv2.deliciousfood.View.Fragments.NotificationsFragment;
import com.example.simplifyv2.deliciousfood.View.Fragments.CartFragment;
import com.example.simplifyv2.deliciousfood.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        //navigation menu button
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //Khởi tạo fragment home khi ứng dụng chạy
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain, new HomeFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_cart:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain, new CartFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain, new NotificationsFragment()).commit();
                    return true;
                case R.id.navigation_account:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain, new AccountFragment()).commit();
                    return true;
            }
            return false;
        }
    };
}
