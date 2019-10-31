package com.example.carmonitor;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreen extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        manager=getSupportFragmentManager();

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistner);

        manager.beginTransaction().replace(R.id.fragmnet_conteiner,
                new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            if(manager.findFragmentByTag(HomeFragment.TAG)==null) {
                                selectedFragment = new HomeFragment();
                            }
                            break;
                        case R.id.nav_profile:
                            if(manager.findFragmentByTag(ProfileFragment.TAG)==null) {
                                selectedFragment = new ProfileFragment();
                            }
                            break;
                        case R.id.nav_map:
                            if(manager.findFragmentByTag(MapFragment.TAG)==null) {
                                selectedFragment = new MapFragment();
                            }
                            break;
                    }

                    manager.beginTransaction().replace(R.id.fragmnet_conteiner,
                            selectedFragment).commit();
                    return true;
                }
            };
}
