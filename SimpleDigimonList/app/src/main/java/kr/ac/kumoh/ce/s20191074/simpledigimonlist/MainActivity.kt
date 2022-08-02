package kr.ac.kumoh.ce.s20191074.simpledigimonlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kr.ac.kumoh.ce.s20191074.simpledigimonlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    val mArray = arrayOf("신태일", "아구몬", "매튜", "파피몬", "한소라", "피요몬", "장한솔", "텐타몬",
        "이미나", "팔몬", "정석", "쉬라몬", "리키", "파닥몬", "신나리", "가트몬")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, mArray)

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, mArray[position], Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("https://www.google.com/search?q=" + mArray[position])
            //val uri = Uri.parse("https://www.youtube.com/results?search_query=" + mArray[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}