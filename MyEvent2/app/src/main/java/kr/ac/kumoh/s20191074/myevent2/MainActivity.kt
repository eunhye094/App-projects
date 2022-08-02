package kr.ac.kumoh.s20191074.myevent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kr.ac.kumoh.s20191074.myevent2.databinding.ActivityMainBinding

//class MainActivity : AppCompatActivity(), View.OnClickListener{
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

//    inner class MyHandler : View.OnClickListener{
//        override fun onClick(p0: View?) {
//            binding.textView.text = "또 다시 눌렸습니다"
//            binding.textView.textSize - 50.toFloat()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.button.setOnClickListener({v: View -> {binding.textView.text = "눌렸습니다2"}})

        binding.button.setOnClickListener {
            binding.textView.text = "눌렸습니다 2"
            binding.textView.textSize - 50.toFloat()
        }

        //val h: MyHandler = MyHandler()
        //binding.button.setOnClickListener(h)    //또 다시 눌렸습니다 출력

        //binding.button.setOnClickListener(this)   //또 눌렸습니다 출력
    }

//    fun onClick(v: View){
//        binding.textView.text = "눌렸습니다"
//        binding.textView.textSize - 50.toFloat()
//        Toast.makeText(this, "눌렸습니다", Toast.LENGTH_SHORT).show()
//    }

//    override fun onClick(p0: View?) {
////        //TODO("Not yet implemented")
////        binding.textView.text = "또 눌렸습니다"
////        binding.textView.textSize - 50.toFloat()
////    }
}