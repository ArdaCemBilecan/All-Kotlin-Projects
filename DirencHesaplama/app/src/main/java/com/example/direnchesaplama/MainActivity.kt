package com.example.direnchesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    var yuzde=""
    var sonuc=0
    var tumRenkler = arrayOf(R.drawable.siyah,R.drawable.kahverengi,R.drawable.kirmizi,R.drawable.turuncu,
        R.drawable.sari,R.drawable.yesil,R.drawable.mavi,R.drawable.mor,R.drawable.gri,R.drawable.beyaz)
    var Tolerans = arrayOf(R.drawable.altin,R.drawable.gumus)
    // Degiskenlere atadık!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var spn1 = findViewById<Spinner>(R.id.renk1) as Spinner
        var spn2 = findViewById<Spinner>(R.id.renk2) as Spinner
        var spn3 = findViewById<Spinner>(R.id.renk3) as Spinner
        var tolerans = findViewById<Spinner>(R.id.tolerans) as Spinner

      // Spinnerlara renk atama işlmeleri
        val customAdapter = CostumAdapter(this,tumRenkler)
        val CA = CostumAdapter(this,Tolerans)
        spn1.adapter=customAdapter
        spn2.adapter=customAdapter
        spn3.adapter=customAdapter
        tolerans.adapter = CA


        spn1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var sayi = pow(10.toDouble(),1.toDouble()).toInt()
                sayi = sayi*position

                sonuc = sayi

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        spn2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
               sonuc = sonuc+position

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        spn3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var carpan = pow(10.toDouble(),position.toDouble()).toInt()
                sonuc = sonuc*carpan
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }


        tolerans.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if(position==0){
                    yuzde = "±%5"
                }else{
                    yuzde = "±%20"
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        btnHesapla.setOnClickListener {
            if(sonuc>1000 && sonuc<1000000){
                var toplam = sonuc.toDouble()/1000
                tvSonuc.text = toplam.toString()+"K"
            }
            if(sonuc>1000000){
                var toplam = sonuc.toDouble()/1000000
                tvSonuc.text = toplam.toString()+"M"
            }

            tvYuzde.text = yuzde
            sonuc = 0
        }

    }

}
