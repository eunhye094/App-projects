package kr.ac.kumoh.ce.s20191074.gunplaapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.ce.s20191074.gunplaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    // Delegated Property
    private val model: GunplaViewModel by viewModels()
    private lateinit var adapter: GunplaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = GunplaAdapter(model) { mechanic -> adapterOnClick(mechanic) }
        binding.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = this@MainActivity.adapter
        }

        // import androidx.lifecycle.Observer
        model.list.observe(this, {
            adapter.notifyDataSetChanged()
        })

        model.requestMechanic()
    }

    private fun adapterOnClick(mechanic: GunplaViewModel.Mechanic) {
        //Toast.makeText(this, mechanic.model, Toast.LENGTH_SHORT).show()
        val uri = Uri.parse("https://www.youtube.com/results?search_query=${mechanic.model}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}