package com.example.facturas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Logo Splash Screen
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
    }
}