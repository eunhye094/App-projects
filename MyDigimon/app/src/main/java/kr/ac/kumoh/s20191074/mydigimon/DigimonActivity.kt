package kr.ac.kumoh.s20191074.mydigimon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20191074.mydigimon.databinding.ActivityDigimonBinding

class DigimonActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDigimonBinding
    companion object{
        const val result: String = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDigimonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.setText(intent.getStringExtra(MainActivity.keyName))

        when (intent.getStringExtra(MainActivity.keyName)){
            "Digimon" -> binding.imageView.setImageResource(R.drawable.digimon)
            "Koromon" -> binding.imageView.setImageResource(R.drawable.koromon)
        }

        binding.btnApply.setOnClickListener{
            val result = Intent()
            result.putExtra(DigimonActivity.result, binding.editText.text.toString())
            //함수 내에서 result 변수를 선언했기 때문에 const val result 은 DigimonActivity.result 라고 사용
            setResult(RESULT_OK, result)
            finish()
        }
    }
}