package com.example.simplifyv2.deliciousfood.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.simplifyv2.deliciousfood.Fragments.AccountFragment;
import com.example.simplifyv2.deliciousfood.Fragments.HomeFragment;
import com.example.simplifyv2.deliciousfood.Fragments.NotificationsFragment;
import com.example.simplifyv2.deliciousfood.Fragments.CartFragment;
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
        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.fragmentMain, new HomeFragment());
        ftHome.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
                    ftHome.replace(R.id.fragmentMain, new HomeFragment());
                    ftHome.commit();
                    return true;
                case R.id.navigation_cart:
                    FragmentTransaction ftCart = getSupportFragmentManager().beginTransaction();
                    ftCart.replace(R.id.fragmentMain, new CartFragment());
                    ftCart.commit();
                    return true;
                case R.id.navigation_notifications:
                    FragmentTransaction ftNotifications = getSupportFragmentManager().beginTransaction();
                    ftNotifications.replace(R.id.fragmentMain, new NotificationsFragment());
                    ftNotifications.commit();
                    return true;
                case R.id.navigation_account:
                    FragmentTransaction ftAccount = getSupportFragmentManager().beginTransaction();
                    ftAccount.replace(R.id.fragmentMain, new AccountFragment());
                    ftAccount.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }
}
