package kr.ac.kumoh.ce.s20191074.mysonglist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel {
    val list = MutableLiveData<ArrayList<String>>()
    private var songs = ArrayList<String>()

    constructor() : super() {
        list.value = songs
    }

    fun add(song: String) {
        songs.add(song)
        list.value = songs
    }

//    fun getSong(i: Int): String {
//        return songs[i]
//    }
    fun getSong(i: Int) = songs[i]
}