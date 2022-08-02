package kr.ac.kumoh.ce.s20191074.mymultimedia

import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kr.ac.kumoh.ce.s20191074.mymultimedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view : ActivityMainBinding
    var mPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btnPlay.setOnClickListener {
            if (mPlayer == null) {
                mPlayer = MediaPlayer.create(this, R.raw.music)
                mPlayer?.start()
            }
        }
        view.btnVideo.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
        view.btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra("return-data", true)
            startActivityForResult(intent, 100)
        }
    }
//    fun onSoundStop(v: View){     //아래와 동일
    fun View.onSoundStop(){
//        if (mPlayer != null){     //1번
//            mPlayer?.stop()
//            mPlayer = null

//        mPlayer = mPlayer?.let {     //2번
//            it.stop()
//            null
//        }

//        mPlayer = mPlayer?.run {      //3번
//            stop()
//            null
//        }

//        mPlayer = mPlayer?.stop().let { null }  //4번

        mPlayer?.stop().let { null }  //5번
}

    override fun onPause(){
        super.onPause()
        if (mPlayer != null){
            mPlayer?.stop()
            mPlayer = null
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK)
            return
        when (requestCode) {
            100 -> {
                val photo = data?.getParcelableArrayExtra<Bitmap>("data")
                view.imageView.setImageBitmap(photo)
            }
        }
    }
}