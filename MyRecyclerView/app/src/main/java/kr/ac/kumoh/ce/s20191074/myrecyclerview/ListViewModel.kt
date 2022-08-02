package kr.ac.kumoh.ce.s20191074.myrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val list = MutableLiveData<ArrayList<String>>()
    private val songs = ArrayList<String>()

    init {
        list.value = songs
    }

    fun getList(): LiveData<ArrayList<String>> = list
    fun add(song: String) {
        songs.add(song)
        list.value = songs
    }
    fun getSong(i: Int) = songs[i]
    fun getSize() = songs.size
}