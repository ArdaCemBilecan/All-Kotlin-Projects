package com.example.ortalamahesaplama

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.shashank.sony.fancytoastlib.FancyToast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.yeni_ders_layout.view.*

class MainActivity : AppCompatActivity() {

    private val DERSLER = arrayListOf("Algoritma","Fizik","Yapısal Programlama","Matematik","Tarih","Mantık","Astronomi")

    private var tumDersler:ArrayList<Dersler> = ArrayList(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Listemize eklene dersleri ders seçmede görebileceğiz yani kayıt ettik.
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DERSLER)

        etDersAd.setAdapter(adapter)

        // Ders eklediğimiz zaman hesapla butonu çıksın istiyoruz

        if(rootLayout.childCount==0){
            btnHesapla.visibility=View.INVISIBLE   //Görünmez olsun dedik.
        }else btnHesapla.visibility=View.VISIBLE


        btnDersEkle.setOnClickListener {

            if(!etDersAd.text.isNullOrEmpty()){  //Ders ismi boş değilse bunları yap

                var inflater = LayoutInflater.from(this)
                var yeniDersView = inflater.inflate(R.layout.yeni_ders_layout,null)

                // Oluşturduktan sonra belki ders adını değiştirmek isteyeceğiz o yüzden buraya da ekledik.
                yeniDersView.etYeniDersAd.setAdapter(adapter)

                // Static alalndan kullanıcıdan gelen değerleri alalım//

                var dersAdi = etDersAd.text.toString()
                var dersKredi = spnDersKredi.selectedItem.toString()
                var dersHarf = spnDersNot.selectedItem.toString()

                // Burada da yeni_ders_layout a atama yapıp ekle dendiğinde kayıtlı olanı atıcaz//

                yeniDersView.etYeniDersAd.setText(dersAdi)
                yeniDersView.spnYeniDersKredi.setSelection(spinnerIndexBul(spnDersKredi,dersKredi))
                yeniDersView.spnYeniDersNot.setSelection (spinnerIndexBul(spnDersNot,dersHarf))

                //yeniDersView e gerekli atamalar yapıldı EKLE dediğimiz zaman kullanıcdna girelen ifadeler de oluştuurlacak//

                //Layout silme işlemi//

                yeniDersView.btnDersSil.setOnClickListener {
                    rootLayout.removeView(yeniDersView)
                    if(rootLayout.childCount==0){
                        btnHesapla.visibility=View.INVISIBLE   //Görünmez olsun dedik.
                    }else btnHesapla.visibility=View.VISIBLE
                }

                rootLayout.addView(yeniDersView)
                btnHesapla.visibility=View.VISIBLE // Burda her ne olursa olsun eleman eklinmiş olacağı için görünürlğü açlıyorsun

                sifirla() //Spinnerları esi haline çevirdik

            }else {
                FancyToast.makeText(this,"DERS ADINI BOŞ BIRAKAMAZSINIZ!",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show()
                 //Ders adı boş ise uyarı yazdırdık
            }



        }

    }
    fun sifirla(){
        etDersAd.setText("")
        spnDersKredi.setSelection(0)
        spnDersNot.setSelection(0)
    }

    fun spinnerIndexBul(spinner: Spinner, aranan: String):Int{
        var index = 0
        for(i in 0..spinner.count){
            if(spinner.getItemAtPosition(i).toString().equals(aranan)){
                index = i
                break
            }
        }
        return index
    }


    fun ortalamaHesapla(v:View){

        var toplamNot=0.0
        var toplamKredi = 0.0

        for(i in 0..rootLayout.childCount-1){
            var tekSatir= rootLayout.getChildAt(i)
            var geciciDers = Dersler(tekSatir.etYeniDersAd.text.toString()
            , ((tekSatir.spnYeniDersKredi.selectedItemPosition)+1).toString()
            , tekSatir.spnYeniDersNot.selectedItem.toString())

            tumDersler.add(geciciDers)
        }

        for(oankiDers in tumDersler){
            toplamNot +=harfiNotaCevir(oankiDers.dersNot)*(oankiDers.dersKredi.toDouble())
            toplamKredi +=oankiDers.dersKredi.toDouble()
        }

     FancyToast.makeText(this,"ORTALAMA: "+ (toplamNot/toplamKredi),FancyToast.LENGTH_LONG,FancyToast.INFO,true).show()

        tumDersler.clear()
    }

    fun harfiNotaCevir(gelenNotDegeri:String):Double{
        var deger = 0.0

        when(gelenNotDegeri){
            "AA"-> deger =4.0
            "BA"-> deger =3.5
            "BB"-> deger =3.0
            "CB"-> deger =2.5
            "CC"-> deger =2.0
            "DC"-> deger =1.5
            "DD"-> deger =1.0
            "FF"-> deger =0.0
        }
        return deger
    }



}
