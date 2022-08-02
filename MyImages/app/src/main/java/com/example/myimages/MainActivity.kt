package com.example.myimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var index = 0
    private val images = arrayOf(R.drawable.image1, R.drawable.image2,
        R.drawable.image3, R.drawable.image4, R.drawable.image5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            index = ++index % images.size
            val d = ResourcesCompat.getDrawable(resources, images[index], null)
//            if (d != null)
//                imageView.setImageDrawable(d)
            d?.let { imageView.setImageDrawable(d) }
        }
    }
}