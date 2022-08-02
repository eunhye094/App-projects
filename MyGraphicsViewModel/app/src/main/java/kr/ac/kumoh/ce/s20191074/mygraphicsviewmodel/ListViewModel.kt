package kr.ac.kumoh.ce.s20191074.mygraphicsviewmodel

import android.graphics.PointF
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    var list = arrayListOf<PointF>()
    
    fun add(x: Float, y: Float) {
        val p = PointF(x, y)
        list.add(p)
    }
}