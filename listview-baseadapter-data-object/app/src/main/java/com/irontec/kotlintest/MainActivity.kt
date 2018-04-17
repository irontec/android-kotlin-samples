package com.irontec.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.irontec.kotlintest.adapters.CustomListAdapter
import com.irontec.kotlintest.models.CustomPojo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listdata = Array(90, {i -> CustomPojo(name = i.toString())})

        val adapter = CustomListAdapter(data = listdata, context = this)

        this.list.adapter = adapter

        this.list.setOnItemClickListener { parent, view, position, id ->
            val myItem = parent.getItemAtPosition(position) as CustomPojo
            Log.d("ITEM", "Custom Pojo " + myItem.name)
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

    fun getLastNumber(dataset: Array<Int>) : Int {
        return dataset.last()
    }
}
