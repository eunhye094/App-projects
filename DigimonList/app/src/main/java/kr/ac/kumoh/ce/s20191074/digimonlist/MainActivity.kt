package kr.ac.kumoh.ce.s20191074.digimonlist

import android.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kr.ac.kumoh.ce.s20191074.digimonlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    data class Digimon (var name: String, var digimon: String)

    var mArray = ArrayList<Digimon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        mArray.add(Digimon("신태일", "아구몬"))
        mArray.add(Digimon("매튜", "파피몬"))
        mArray.add(Digimon("한소라", "피요몬"))
        mArray.add(Digimon("장한솔", "텐타몬"))
        mArray.add(Digimon("이미나", "팔몬"))
        mArray.add(Digimon("정석", "쉬라몬"))
        mArray.add(Digimon("리키", "파닥몬"))
        mArray.add(Digimon("신나리", "가트몬"))
        mArray.add(Digimon("우정훈", "아그니몬"))
        mArray.add(Digimon("선우현", "볼프몬"))
        mArray.add(Digimon("안도영", "블리츠몬"))
        mArray.add(Digimon("고은비", "페어리몬"))
        mArray.add(Digimon("진가람", "챠크몬"))
        mArray.add(Digimon("선우윤", "레베몬"))

        //binding.listView.adapter = DigimonAdapter_Base(this)
        binding.listView.adapter = DigimonAdapter_Array(this,
            android.R.layout.simple_list_item_1, mArray)

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, mArray[position].digimon, Toast.LENGTH_SHORT).show()

            val uri = Uri.parse("https://www.google.com/search?q=" + mArray[position])
            //val uri = Uri.parse("https://www.youtube.com/results?search_query=" + mArray[position])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private class DigimonViewHolder{
        lateinit var txName: TextView
        lateinit var txDigimon: TextView
    }

    inner class DigimonAdapter_Base(context: Context) : BaseAdapter(){
        private var mInflater = LayoutInflater.from(context)

        override fun getCount(): Int {
            return mArray.size
        }

        override fun getItem(position: Int): Any {
            return mArray[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View
            val viewHolder: DigimonViewHolder

            if (convertView == null) {
                view = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
                viewHolder = DigimonViewHolder()
                viewHolder.txName = view.findViewById(android.R.id.text1)
                viewHolder.txDigimon = view.findViewById(android.R.id.text2)
                view.tag = viewHolder
            }
            else {
                view = convertView
                viewHolder = view.tag as DigimonViewHolder
            }

            viewHolder.txName.text = mArray[position].name
            viewHolder.txDigimon.text = mArray[position].name
            return view
        }
    }

    inner class DigimonAdapter_Array(context: Context, resource: Int, objects: MutableList<Digimon>) :
        ArrayAdapter<Digimon>(context, resource, objects){
            private var mInflater = LayoutInflater.from(context)

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view: View
                val viewHolder: DigimonViewHolder

                if (convertView == null) {
                    view = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
                    viewHolder = DigimonViewHolder()
                    viewHolder.txName = view.findViewById(android.R.id.text1)
                    viewHolder.txDigimon = view.findViewById(android.R.id.text2)
                    view.tag = viewHolder
                }
                else {
                    view = convertView
                    viewHolder = view.tag as DigimonViewHolder
                }

                viewHolder.txName.text = getItem(position)?.name
                viewHolder.txDigimon.text = getItem(position)?.digimon
                return view
            }
        }
}