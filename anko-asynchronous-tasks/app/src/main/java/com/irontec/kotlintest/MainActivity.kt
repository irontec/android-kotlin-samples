package com.irontec.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.gson.GsonBuilder
import com.irontec.kotlintest.deserializers.WeatherDeserializer
import com.irontec.kotlintest.models.WeatherObject
import com.irontec.kotlintest.networking.NetworkClient
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(5)
            val mTextView = textView {
                textSize = 16f
                width = matchParent
                height = dip(300)
            }
            button("Retrieve Weather") {
                textSize = 14f
                width = matchParent
                height = wrapContent
                onClick {
                    // Declare a background asynchronous task, no need for an AsyncTask anymore
                    doAsync {
                        // Heavy duty work made on the background
                        val networkClient = NetworkClient()
                        val stream = BufferedInputStream(
                                networkClient.get("https://raw.githubusercontent.com/irontec/android-kotlin-samples/master/common-data/bilbao.json"))
                        val bufferedReader = BufferedReader(InputStreamReader(stream));
                        val stringBuilder = StringBuilder()
                        bufferedReader.forEachLine { stringBuilder.append(it) }
                        val gsonBuilder = GsonBuilder().serializeNulls()
                        gsonBuilder.registerTypeAdapter(WeatherObject::class.java, WeatherDeserializer());
                        val gson = gsonBuilder.create()
                        val weather = gson.fromJson(stringBuilder.toString(), WeatherObject::class.java)

                        uiThread {
                            // Just set the TextView text on the UI-Thread
                            mTextView.text = weather.toString()
                        }
                    }
                }
            }
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
