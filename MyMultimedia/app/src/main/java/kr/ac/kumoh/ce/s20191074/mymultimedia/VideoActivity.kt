package kr.ac.kumoh.ce.s20191074.mymultimedia

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kr.ac.kumoh.ce.s20191074.mymultimedia.databinding.ActivityMainBinding
import kr.ac.kumoh.ce.s20191074.mymultimedia.databinding.ActivityVideoBinding

class VideoActivity : Activity() {
    private lateinit var view : ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(view.root)

        val uri = Uri.parse("android.resource://$packageName/raw/digimon_opening")
        view.videoView.setVideoURI(uri)
        view.videoView.setMediaController(MediaController(this))    //영상 컨트롤 가능 (정지, 뒤로 가기, 앞으로 가기 등)
        view.videoView.start()
    }
}