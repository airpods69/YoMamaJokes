 package com.sexymama.yomama

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject
import java.net.URL

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yomama().execute()
    }

    inner class yomama() : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg p0: String?): String {
            var response:String?
            response = URL("https://api.yomomma.info/").readText(Charsets.UTF_8)

            return response

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val jsonObj = JSONObject(result)
            findViewById<TextView>(R.id.jokeText).text = jsonObj.getString("joke")
        }
    }
}