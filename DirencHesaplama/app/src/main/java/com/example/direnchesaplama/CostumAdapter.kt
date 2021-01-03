package com.example.direnchesaplama

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Spinner
import java.util.zip.Inflater

class CostumAdapter(var context: Context, var renkler:Array<Int>):BaseAdapter()
{
    var inflater:LayoutInflater
    init {
        inflater = LayoutInflater.from(context)
    }
    override fun getView(p0: Int, view: View?, p2: ViewGroup?): View {
        val view = inflater.inflate(R.layout.spinner_custom_layout,null)
        val renk = view.findViewById<View>(R.id.imgRenkler) as ImageView?
        renk!!.setImageResource(renkler[p0])
        return view
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
    return 0
    }

    override fun getCount(): Int {
        return renkler.size
    }
}