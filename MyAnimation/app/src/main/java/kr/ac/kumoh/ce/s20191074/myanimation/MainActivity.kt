package kr.ac.kumoh.ce.s20191074.myanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import kr.ac.kumoh.ce.s20191074.myanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    private var scale: ScaleAnimation? = null
    private var translate: TranslateAnimation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        scale = ScaleAnimation(
            1F, 1F, 0F, (0..100).random().toFloat()/100F,   //랜덤 사용하고 싶으면 모두 setOnClickListener 안에 넣을 것
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 1F
        )
        scale?.duration = 1000
        scale?.fillBefore = false
        scale?.fillAfter = true

        translate = TranslateAnimation(
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, -50F
            )

        view.btnAnimate.setOnClickListener {
            val rotate = RotateAnimation(
                0F, (360..360*4).random().toFloat(),
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f    //중심점
                )
            rotate.duration = 3000  //3초
            rotate.fillBefore = false
            rotate.fillAfter = true

            view.imageView1.startAnimation(rotate)
            view.imageView2.startAnimation(scale)
//            view.imageView2.startAnimation(translate)
        }
    }
}