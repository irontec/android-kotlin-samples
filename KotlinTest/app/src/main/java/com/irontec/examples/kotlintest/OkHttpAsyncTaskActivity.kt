package com.irontec.examples.kotlintest

import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.irontec.examples.kotlintest.networking.NetworkClient
import kotlinx.android.synthetic.main.activity_okhttp_asynctask.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader

class OkHttpAsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp_asynctask)

        GetJsonWithOkHttpClient(this.text).execute()

    }

    open class GetJsonWithOkHttpClient(textView: TextView) : AsyncTask<Unit, Unit, String>() {

        val mInnerTextView = textView

        override fun doInBackground(vararg params: Unit?): String? {
            val networkClient = NetworkClient()
            val stream = BufferedInputStream(
                    networkClient.get("https://raw.githubusercontent.com/irontec/android-kotlin-samples/master/common-data/bilbao.json"))
            return readStream(stream)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            mInnerTextView.text = result

        }

        fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
