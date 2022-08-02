package kr.ac.kumoh.ce.s20191074.digimonadventure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.ce.s20191074.digimonadventure.databinding.ActivityDigimonBinding
import java.net.URLEncoder

class DigimonActivity : AppCompatActivity() {
    private lateinit var layout: ActivityDigimonBinding
    private lateinit var digimonVM: DigimonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityDigimonBinding.inflate(layoutInflater)
        setContentView(layout.root)

        digimonVM = ViewModelProvider(this).get(DigimonViewModel::class.java)
        layout.name.text = intent.getStringExtra("name")
        val url = "${DigimonViewModel.SERVER}/cover/"+URLEncoder.encode(intent.getStringExtra("image"), "utf-8")
        layout.cover.setImageUrl(url, digimonVM.getImageLoader())
        layout.memo.text = intent.getStringExtra("memo")
    }
}