package kr.ac.kumoh.ce.s20191074.myconstraintlayoutanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import androidx.constraintlayout.widget.ConstraintSet
import kr.ac.kumoh.ce.s20191074.myconstraintlayoutanimation.databinding.ActivityMainStartBinding

class MainActivity : AppCompatActivity() {
    lateinit var view : ActivityMainStartBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainStartBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btnChange.setOnClickListener {
            val cs1 = ConstraintSet()
            cs1.clone(view.constraintLayout)

            val cs2 = ConstraintSet()
            cs2.clone(this, R.layout.activity_main_end)

            TransitionManager.beginDelayedTransition(view.constraintLayout)

            cs2.applyTo(view.constraintLayout)
        }
    }
}