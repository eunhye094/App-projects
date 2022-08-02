package kr.ac.kumoh.ce.s20191074.digimonadventure

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kumoh.ce.s20191074.digimonadventure.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var digimonVM: DigimonViewModel
    private lateinit var layout: ActivityMainBinding
    private lateinit var digimon: DigimonAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        digimonVM = ViewModelProvider(this).get(DigimonViewModel::class.java)
        digimon = DigimonAdapter(digimonVM) { member -> adapterOnClick(member) }
        layout.digimons.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = digimon
        }
        digimonVM.getLiveData().observe(this, Observer<ArrayList<DigimonViewModel.Member>>{
            digimon.notifyDataSetChanged()
        })
        digimonVM.getMembers()
    }
    private fun adapterOnClick(member: DigimonViewModel.Member) {
        val intent = Intent(this, DigimonActivity::class.java)
        intent.putExtra("name", member.name)
        intent.putExtra("image", member.image)
        intent.putExtra("memo", member.memo)
        startActivity(intent)
    }
}