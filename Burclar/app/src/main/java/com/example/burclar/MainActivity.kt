package com.example.burclar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tek_satir.*

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri:ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiHazirla()

        var BurclarAdapter = MyBaseAdapter(this , tumBurcBilgileri)
        listBurclar.adapter = BurclarAdapter

        listBurclar.setOnItemClickListener { adapterView, view, position, l ->

            var intent = Intent(this@MainActivity,DetayActivity::class.java)

            intent.putExtra("tiklanilan",position)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)
            startActivity(intent)

        }


    }

    private fun veriKaynagiHazirla() {

        tumBurcBilgileri= ArrayList<Burc>(12)
        var burclar = resources.getStringArray(R.array.burcAdlari)

        var burcTarih = resources.getStringArray(R.array.burcTarihleri)

        var burcResimleri = arrayOf(R.drawable.koc1,R.drawable.boga2,R.drawable.ikizler3,
            R.drawable.yengec4,R.drawable.aslan5,R.drawable.basak6,R.drawable.terazi7,
            R.drawable.akrep8,R.drawable.yay9,R.drawable.oglak10,R.drawable.kova11,R.drawable.balik12)

        var buyukBurcResimleri = arrayOf(R.drawable.koc1,R.drawable.boga2,R.drawable.ikizler3,
            R.drawable.yengec4,R.drawable.aslan5,R.drawable.basak6,R.drawable.terazi7,
            R.drawable.akrep8,R.drawable.yay9,R.drawable.oglak10,R.drawable.kova11,R.drawable.balik12)
         var burcGenelOzellik= resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in 0..11){
            var arrayListeAtanacakBurc = Burc(burclar[i],burcTarih[i],burcResimleri[i],buyukBurcResimleri[i],burcGenelOzellik[i])
            tumBurcBilgileri.add(arrayListeAtanacakBurc)
        }

    }


}
