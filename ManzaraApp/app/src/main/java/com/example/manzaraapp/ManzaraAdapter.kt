package com.example.manzaraapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_view.view.*


class ManzaraAdapter(tumManzaralar:ArrayList<Manzara>):RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>(){

    var manzaralar = tumManzaralar

    override fun getItemCount(): Int {
        return manzaralar.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraAdapter.ManzaraViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var tekSatirView = inflater.inflate(R.layout.tek_satir_view,parent,false)
        return ManzaraViewHolder(tekSatirView)
    }

    override fun onBindViewHolder(holder: ManzaraAdapter.ManzaraViewHolder, position: Int) {
        var oankiManzara = manzaralar.get(position)
        holder.setData(oankiManzara,position)
    }

    inner class ManzaraViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var tekSatirManzara = itemView as CardView
        var manzaraBaslik = tekSatirManzara.tvManzaraBaslik
        var manzaraAciklama = tekSatirManzara.tvManzaraAciklama
        var manzaraResim = tekSatirManzara.imgManzara
        var btnSil = tekSatirManzara.imgSil
        var btnKopyalana = tekSatirManzara.imgKopyala

        fun setData(oankiManzara:Manzara,position: Int){
            manzaraBaslik.text = oankiManzara.baslik
            manzaraAciklama.text = oankiManzara.aciklama
            manzaraResim.setImageResource(oankiManzara.resim)

           btnSil.setOnClickListener {
               manzaralar.removeAt(position)
               notifyItemRemoved(position)
               notifyItemRangeChanged(position,manzaralar.size)
           }


            btnKopyalana.setOnClickListener {
                manzaralar.add(position,oankiManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)
            }

        }

    }


}

