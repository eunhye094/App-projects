package kr.ac.kumoh.ce.s20191074.mysonglist2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import kr.ac.kumoh.ce.s20191074.mysonglist2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    private lateinit var model: SongViewModel
    private val mAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        model = ViewModelProvider(this).get(SongViewModel::class.java)

        view.list.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = mAdapter
        }

        model.list.observe(this,
            Observer<ArrayList<SongViewModel.Song>>{
                mAdapter.notifyDataSetChanged()
            }
        )

        model.requestSong()
    }

    inner class SongAdapter: RecyclerView.Adapter<SongAdapter.ViewHolder>(){
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            //val txText: TextView = itemView.findViewById(android.R.id.text1)  //12주차 1번
            //val txTitle: TextView = itemView.findViewById(android.R.id.text1)   //12주차 2번
            //val txSinger: TextView = itemView.findViewById(android.R.id.text2)  //12주차 2번
            val txTitle: TextView = itemView.findViewById(R.id.text1)   //14주차
            val txSinger: TextView = itemView.findViewById(R.id.text2)  //14주차
            val niImage: NetworkImageView = itemView.findViewById(R.id.image)   //14주차

            init {  //14주차
                niImage.setDefaultImageResId(android.R.drawable.ic_menu_report_image)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            //val view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false) //12주차 1번
            //val view = layoutInflaLter.inflate(android.R.layout.simple_list_item_2, parent, false)   //12주차 2번
            val view = layoutInflater.inflate(R.layout.item_song, parent, false)    //14주차
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //holder.txText.text = model.getSong(position).toString()
            holder.txTitle.text = model.getSong(position).title
            holder.txSinger.text = model.getSong(position).singer
            holder.niImage.setImageUrl(model.getImageUrl(position), model.imageLoader)
        }

        override fun getItemCount() = model.getSize()
    }
}