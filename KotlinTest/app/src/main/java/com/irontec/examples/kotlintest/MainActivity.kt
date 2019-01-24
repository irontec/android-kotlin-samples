package com.irontec.examples.kotlintest

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.irontec.examples.kotlintest.adapters.ActivityAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.list)
        list.adapter = ActivityAdapter(this@MainActivity)

        list.onItemClickListener =
                AdapterView.OnItemClickListener { parent, v, position, id ->
                    when(position) {
                        0 -> startActivity(Intent(this@MainActivity, AnkoAsyncTaskActivity::class.java))
                        1 -> startActivity(Intent(this@MainActivity, AnkoSimpleUiActivity::class.java))
                        2 -> startActivity(Intent(this@MainActivity, GsonDeserializerOkhttpAsyncActivity::class.java))
                        3 -> startActivity(Intent(this@MainActivity, HttpUrlConnectionAsyncActivity::class.java))
                        4 -> startActivity(Intent(this@MainActivity, ListviewBaseAdapterDataObjActivity::class.java))
                        5 -> startActivity(Intent(this@MainActivity, OkHttpAsyncTaskActivity::class.java))
                    }
                }
    }
}