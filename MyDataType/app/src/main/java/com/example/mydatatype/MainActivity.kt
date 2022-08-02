package com.example.mydatatype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_button_plus.setOnClickListener {
              my_text.text = "${++count}"
        }

        my_button_sub.setOnClickListener {
            if (--count < 0)
                count = 0
            my_text.text = "$count"
        }

        my_button_reset.setOnClickListener {
            count = 0
            my_text.text = "$count"
        }

        my_button_set.setOnClickListener {
            count = my_edit.text.toString().toIntOrNull() ?: count
            my_text.text = "$count"
        }
    }
}