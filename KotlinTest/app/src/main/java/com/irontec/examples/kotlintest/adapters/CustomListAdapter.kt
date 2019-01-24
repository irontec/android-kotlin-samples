package com.irontec.examples.kotlintest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.irontec.examples.kotlintest.R
import com.irontec.examples.kotlintest.models.CustomPojo

/**
 * Created by axier on 22/4/15.
 */
open class CustomListAdapter(data: Array<CustomPojo>, context: Context) : BaseAdapter()  {

    val mInflater: LayoutInflater = LayoutInflater.from(context)
    var localData = data

    override fun getCount(): Int {
        return localData.size
    }

    override fun getItem(position: Int): Any {
        return localData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.row_item, parent, false)
            vh = ListRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.label.text = localData.get(index = position).toString()
        return view
    }

    private class ListRowHolder(row: View?) {

        val label: TextView = row?.findViewById(R.id.label) as TextView

    }

}