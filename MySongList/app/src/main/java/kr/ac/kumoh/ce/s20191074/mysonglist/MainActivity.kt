package kr.ac.kumoh.ce.s20191074.mysonglist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.ce.s20191074.mysonglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding;

//    private val array = arrayOf("Just U", "BABY IT'S U", "20 Something", "Feeling", "비가 온대 그날처럼",
//        "뭔가 있어", "It's you", "이봐 이봐 이봐", "Good night", "그대였습니다", "너를 그린다", "DOOR")
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var model: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(ListViewModel::class.java)

        val listObserver = Observer<ArrayList<String>> {
            adapter.notifyDataSetChanged()
        }
        model.list.observe(this, listObserver)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, model.list.value as List<String>)
        //adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, model.list.value)   //원래 이건데 오류때문에 수정
        view.listView.adapter = adapter

        model.add("Just U")
        model.add("BABY IT'S U")

        view.listView.setOnItemClickListener { _, _, position, _ ->
            val uri = Uri.parse("https://www.youtube.com/results?search_query="+"노래방 ${model.getSong(position)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        view.fab.setOnClickListener { view ->
            val customLayout = layoutInflater.inflate(R.layout.dailog_input, null)
            AlertDialog.Builder(this).setView(customLayout).setPositiveButton("추가") { _, _ ->
                val edit = customLayout.findViewById<EditText>(R.id.edit)
                if (edit.text.toString().length > 0)
                    model.add(edit.text.toString())
            }.create().show()
        }
    }
}
