package com.example.burclar

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position = intent.extras!!.get("tiklanilan") as Int
        var tumBurcBilgileri = intent.extras!!.get("tumBurcBilgileri") as ArrayList<Burc>
        tvBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcGenelOzellik)
        header.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi

        var bitmap = BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
                var color = palette?.getVibrantColor(R.attr.colorAccent)

                collapsing_toolbar.setContentScrimColor(color!!)

                window.statusBarColor = color

            }
        })


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}
