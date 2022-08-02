package kr.ac.kumoh.ce.s20191074.digimonadventure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView

class DigimonAdapter(private val vm: DigimonViewModel,
                     private val onClick: (DigimonViewModel.Member) -> Unit
): RecyclerView.Adapter<DigimonAdapter.ViewHolder>() {

        inner class ViewHolder(root: View): RecyclerView.ViewHolder(root) {
            val name: TextView = root.findViewById(R.id.name)
            val crest: TextView = root.findViewById(R.id.crest)
            val cover: NetworkImageView = root.findViewById(R.id.cover)
            init {
                cover.setDefaultImageResId(android.R.drawable.ic_menu_report_image)
                root.setOnClickListener { onClick(vm.getMember(adapterPosition)) }
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_digimon, parent, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = vm.getMember(position).name
            holder.crest.text = vm.getMember(position).crest
            holder.cover.setImageUrl(vm.getImageUrl(position), vm.getImageLoader())
        }
        override fun getItemCount() = vm.getSize()
}