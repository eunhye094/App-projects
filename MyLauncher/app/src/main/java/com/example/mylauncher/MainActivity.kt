package com.example.mylauncher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //sleep(3000)
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyLauncher)
        setContentView(R.layout.activity_main)
    }
}