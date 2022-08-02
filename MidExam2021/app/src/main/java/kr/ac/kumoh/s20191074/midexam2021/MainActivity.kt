package kr.ac.kumoh.s20191074.midexam2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import kr.ac.kumoh.s20191074.midexam2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view : ActivityMainBinding

    private val digiDestinedImages = arrayOf(R.drawable.taichi, R.drawable.yamato, R.drawable.sora,
        R.drawable.koshiro, R.drawable.mimi, R.drawable.joe, R.drawable.takeru, R.drawable.hikari)
    private val digimonImages = arrayOf(R.drawable.agumon, R.drawable.gabumon, R.drawable.piyomon,
        R.drawable.tentomon, R.drawable.palmon, R.drawable.gomamon, R.drawable.patamon, R.drawable.gatomon)

    private val digiDestinedString = arrayOf(R.string.taichi, R.string.yamato, R.string.sora,
        R.string.koshiro, R.string.mimi, R.string.joe, R.string.takeru, R.string.hikari)
    private val digimonString = arrayOf(R.string.agumon, R.string.gabumon, R.string.piyomon,
        R.string.tentomon, R.string.palmon, R.string.gomamon, R.string.patamon, R.string.gatomon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        val imageView = arrayOf(view.imgCourage, view.imgFriendship, view.imgLove, view.imgKnowledge,
            view.imgPurity, view.imgHonesty, view.imgHope, view.imgLight)
        val textView = arrayOf(view.textCourage, view.textFriendship, view.textLove, view.textKnowledge,
            view.textPurity, view.textHonesty, view.textHope, view.textLight)

        view.itemCourage.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.courage, Toast.LENGTH_LONG).show()
        }
        view.itemFriendship.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.friendship, Toast.LENGTH_LONG).show()
        }
        view.itemLove.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.love, Toast.LENGTH_LONG).show()
        }
        view.itemKnowledge.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.knowledge, Toast.LENGTH_LONG).show()
        }
        view.itemPurity.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.purity, Toast.LENGTH_LONG).show()
        }
        view.itemHonesty.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.honesty, Toast.LENGTH_LONG).show()
        }
        view.itemHope.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.hope, Toast.LENGTH_LONG).show()
        }
        view.itemLight.setOnClickListener{
            Toast.makeText(applicationContext,
                R.string.light, Toast.LENGTH_LONG).show()
        }

        view.btnDigiDestined.setOnClickListener{
            for (i in 0..7){
                val d = ResourcesCompat.getDrawable(resources, digiDestinedImages[i], null)
                d?.let { imageView[i].setImageDrawable(d) }
                textView[i].text = getString(digiDestinedString[i])
            }
        }
        view.btnDigimon.setOnClickListener {
            for (i in 0..7){
                val d = ResourcesCompat.getDrawable(resources, digimonImages[i], null)
                d?.let { imageView[i].setImageDrawable(d) }
                textView[i].text = getString(digimonString[i])
            }
        }

        view.button.setOnClickListener {
            view.scroll.fullScroll(ScrollView.FOCUS_UP)
        }
    }
}