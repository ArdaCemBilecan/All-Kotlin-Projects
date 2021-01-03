package com.example.burclar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class MyBaseAdapter(contex:Context,tumBurcBilgileri:ArrayList<Burc>) :BaseAdapter() {

   var tumBurclar: ArrayList<Burc>
    var contex:Context

    init {
        this.tumBurclar = tumBurcBilgileri
        this.contex = contex

    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View ?{

        var tekSatirView = convertView
        var viewHolder : ViewHolder2

        if(tekSatirView ==null){
            var inflater = LayoutInflater.from(contex)
            tekSatirView = inflater.inflate(R.layout.tek_satir,parent,false)

            viewHolder = ViewHolder2(tekSatirView)

            tekSatirView.tag = viewHolder

        }else{

            viewHolder = tekSatirView.getTag() as ViewHolder2

        }



        viewHolder.burcResim.setImageResource(tumBurclar.get(position).burcResim)
        viewHolder.burcTarih.setText(tumBurclar.get(position).burcTarih)
        viewHolder.burcAd.setText(tumBurclar.get(position).burcAdi)


     return tekSatirView
    }

    override fun getItem(pozition: Int): Any {
         return tumBurclar.get(pozition)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return tumBurclar.size
    }

}

class ViewHolder2 (tekSatirView: View){

    var burcResim: ImageView

    var burcAd : TextView

    var burcTarih : TextView

    init {
        this.burcResim = tekSatirView.burcResim
        this.burcAd = tekSatirView.tvBurcAdi
        this.burcTarih = tekSatirView.tvBurcTarih
    }

}