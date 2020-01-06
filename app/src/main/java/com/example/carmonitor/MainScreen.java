package com.example.carmonitor;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreen extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        bottomNavigation =findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_map_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_user_icon));



        manager=getSupportFragmentManager();

//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navlistner);
//
//        bottomNavigationView.setSelectedItemId(R.id.nav_home);
//        manager.beginTransaction().replace(R.id.fragmnet_conteiner,
//                new HomeFragment()).commit();

    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navlistner=
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Fragment selectedFragment=null;
//                    switch (menuItem.getItemId()){
//                        case R.id.nav_home:
//                            if(manager.findFragmentByTag(HomeFragment.TAG)==null) {
//                                selectedFragment = new HomeFragment();
//                            }
//                            break;
//                        case R.id.nav_profile:
//                            if(manager.findFragmentByTag(ProfileFragment.TAG)==null) {
//                                selectedFragment = new ProfileFragment();
//                            }
//                            break;
//                        case R.id.nav_map:
//                            if(manager.findFragmentByTag(MapFragment.TAG)==null) {
//                                selectedFragment = new MapFragment();
//                            }
//                            break;
//                    }
//
//                    manager.beginTransaction().replace(R.id.fragmnet_conteiner,
//                            selectedFragment).commit();
//                    return true;
//                }
//            };
}
