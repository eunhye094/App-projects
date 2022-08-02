package kr.ac.kumoh.ce.s20191074.mycrawler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kr.ac.kumoh.ce.s20191074.mycrawler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        val queue = Volley.newRequestQueue(this)

        val url = "https://bwoh.tistory.com"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                //모든 내용을 text로 출력
//                view.textView.text = response

                //webView로 출력
//                view.webView.settings.defaultTextEncodingName = "UTF-8"
//                view.webView.loadData(response, "text/html;charset=UTF-8", null)

                val ogTitle = "\"og:title\""
                val ogDesc = "\"og:description\""
                val ogImage = "\"og:image\""

                val resultTitle = findContent(response, ogTitle, 0)
                val resultDesc = findContent(response, ogDesc, 0)
                val resultImage = findContent(response, ogImage, 0)

                //text와 image 출력
//                val text = "${resultTitle}\n" + "${resultDesc}"
//                view.textView.text = text
//                view.webView.loadUrl(resultImage)

                //html을 사용하여 text와 image 출력
                val html = """
                    <html>
                        <body>
                            <h1>$resultTitle</h1>
                            <p>$resultDesc</p>
                            <img src="$resultImage"/>
                        </body>
                    </html>
                """.trimIndent()

                view.webView.settings.defaultTextEncodingName = "UTF-8"
                view.webView.loadData(html, "text/html;charset=UTF-8", null)
            },
            {
                view.textView.text = "Error: $it"
            }
        )
        queue.add(stringRequest)
    }

    fun findContent(target: String, meta: String, startIndex: Int): String {
        val content = "content=\""
        val close = "\" >"

        var start = target.indexOf(meta)
        start = target.indexOf(content, start)
        val end = target.indexOf(close, start)

        return target.substring(start + content.length..end-1)
    }
}