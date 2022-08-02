package kr.ac.kumoh.ce.s20191074.mystringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.ce.s20191074.mystringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    
    private val songs = arrayOf(
        "사랑은 늘 도망가", "구원자", "그대의 의도", "우린 결국 그렇게", "너 하나야", "Antifreeze",
        "집이 돼줄게", "가을 타나봐", "왜? 날", "토핑은 필요 없어", "STAY", "고백", "하기나 해"
    )
    //private val places = arrayOf("폴컨 베이커리", "옥계동 징기스")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
        
        view.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            songs)

        view.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://youtube.com/results?search_query=노래방+" + songs[i])
            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)
            //val uri = Uri.parse("https://www.google.com/maps/search/" + places[i]) 사용 가능
        }
    }
}