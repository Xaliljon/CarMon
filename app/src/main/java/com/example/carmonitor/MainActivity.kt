package com.example.carmonitor

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_registr.setOnClickListener {
            val intent=Intent(this,RegisterPage::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener {
            val intent=Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
    }
}
