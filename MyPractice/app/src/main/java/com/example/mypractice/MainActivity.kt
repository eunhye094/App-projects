package com.example.mypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypractice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var n: Int = Random.nextInt(1,46)
            binding.text1.text = "$n"
            binding.text2.text = "${Random.nextInt(1,46)}"
        }
    }
}