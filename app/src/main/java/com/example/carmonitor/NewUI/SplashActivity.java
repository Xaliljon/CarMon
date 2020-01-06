package com.example.carmonitor.NewUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.carmonitor.LoginPage;
import com.example.carmonitor.R;
import com.example.carmonitor.RegisterPage;

public class SplashActivity extends AppCompatActivity {
    LinearLayout splash, liner;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        splash = findViewById(R.id.splash);
        liner = findViewById(R.id.liner);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        splash.startAnimation(myanim);
        splash.animate().translationY(-550).setDuration(1000).setStartDelay(2000);
        liner.startAnimation(myanim1);
        liner.animate().translationX(0).setDuration(1000).setStartDelay(2000);

        btnRegister = findViewById(R.id.reg_btn);
        btnLogin = findViewById(R.id.login_btn);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, RegisterPage.class);
                startActivity(intent);
            }
        });


    }
}
