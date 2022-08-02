package com.example.myevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_button.setOnClickListener {
            my_text.text = "1"
        }
    }

//    public fun onButton(v: View) {
//        my_text.text = "눌렸습니다"
//    }
//    +) activity_main.xml button 에 android:onClick="onButton" 추가
}