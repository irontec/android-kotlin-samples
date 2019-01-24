package com.irontec.examples.kotlintest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.irontec.examples.kotlintest.R

open class ActivityAdapter(private val context: Context) : BaseAdapter() {

    val mInflater: LayoutInflater = LayoutInflater.from(context)
    private val activities = arrayOf(
        "Anko async api sample",
        "Anko Simple UI",
        "Gson deserializers with OkHttp and AsyncTask",
        "HttpUrlConnection and AsyncTask",
        "ListView with BaseAdapter and Data Object",
        "OkHttp and AsyncTask"
    )

    override fun getCount(): Int = activities.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ActivityAdapter.ListRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_activity, parent, false)
            vh = ActivityAdapter.ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ActivityAdapter.ListRowHolder
        }
        vh.label.text = activities.get(index = position)
        return view
    }

    private class ListRowHolder(row: View?) {

        val label: TextView = row?.findViewById(R.id.label) as TextView

    }

}