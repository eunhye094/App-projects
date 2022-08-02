package kr.ac.kumoh.s20191074.mydigimon

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.ac.kumoh.s20191074.mydigimon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding : ActivityMainBinding
    companion object{
        const val keyName = "name"
        const val requestDigimon = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDigimon.setOnClickListener(this)
        binding.btnKoromon.setOnClickListener(this)
//        binding.btnDigimon.setOnClickListener {
//            var intent = Intent(this, DigimonActivity::class.java)
//            intent.putExtra(keyName,"Digimon")
//            //intent.putExtra("test", 300)
//            startActivity(intent)
//        }
//        binding.btnKoromon.setOnClickListener {
//            var intent = Intent(this, DigimonActivity::class.java)
//            intent.putExtra(keyName,"Koromon")
//            startActivity(intent)
//        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent (this, DigimonActivity::class.java)
        when (p0?.id){
            binding.btnDigimon.id -> intent.putExtra(keyName, "Digimon")
            binding.btnKoromon.id -> intent.putExtra(keyName, "Koromon")
            null -> return
        }
        //startActivity(intent)
        startActivityForResult(intent, requestDigimon)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK){
            when(requestCode){
                requestDigimon -> {
                    binding.textView.text = data?.getStringExtra(DigimonActivity.result)
                }
            }
        }
    }
}
