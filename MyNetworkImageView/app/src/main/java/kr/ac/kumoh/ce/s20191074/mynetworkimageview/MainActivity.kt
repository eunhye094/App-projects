package kr.ac.kumoh.ce.s20191074.mynetworkimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.s20191074.mynetworkimageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    private lateinit var volley: VolleySingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        volley = VolleySingleton.getInstance(this)

        view.btnConnect.setOnClickListener{
            view.imageView.setImageUrl("https://lh3.googleusercontent.com/proxy/jpHxuanygW3ln1yP0jYpWo5QSsr1oUuPnaOowzqSmH8tsdaV7G5Oly9wg-m6O_jeAYpW1A_h-wv6VD0TT4XjjFY2_ZtcuRBTCMpQWEd0tXg3tSXgEYKJWwETekyUsT9yJq8Xwmqm-C1LpaFwTDlFEbOqGhJ-9QT3Qw",
            volley.imageLoader)
        }
    }
}