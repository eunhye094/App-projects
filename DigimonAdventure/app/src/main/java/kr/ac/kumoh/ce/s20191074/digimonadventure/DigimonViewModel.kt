package kr.ac.kumoh.ce.s20191074.digimonadventure

import android.app.Application
import android.os.strictmode.UntaggedSocketViolation
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder

class DigimonViewModel(application: Application) : AndroidViewModel(application) {
    data class Member(var id: Int, var name: String, var crest: String, var image: String, var memo: String)

    private val list = ArrayList<Member>()
    private val liveData = MutableLiveData<ArrayList<Member>>()
    private var volley = VolleySingleton.getInstance(application).requestQueue
    private val loader = VolleySingleton.getInstance(application).imageLoader

    companion object{
        const val TAG = "DigimonRequest"
        const val SERVER = "https://digimonadventuredb-ipfax.run.goorm.io/"
    }

    init{
        liveData.value = list
    }

    fun getLiveData() = liveData
    fun getImageLoader() = loader
    fun getImageUrl(i: Int): String = "$SERVER/cover/" + URLEncoder.encode(list[i].image, "utf-8")
    fun getMember(i: Int) = list[i]
    fun getSize() = list.size
    fun getMembers() {
        val request = JsonArrayRequest(
            Request.Method.GET,
            "$SERVER/member",
            null,
            {
                list.clear()
                addMembers(it)
                liveData.value = list
            },
            {
                Toast.makeText(getApplication(), it.toString(), Toast.LENGTH_LONG).show()
            }
        )
        request.tag = TAG
        volley.add(request)
    }
    private fun addMembers(a: JSONArray){
        for (i in 0 until a.length()){
            val r = a[i] as JSONObject
            list.add(Member(r.getInt("id"),
            r.getString("name"),
            r.getString("crest"),
            r.getString("image"),
            r.getString("memo")))
        }
    }
    override fun onCleared(){
        super.onCleared()
        volley.cancelAll(TAG)
    }
}