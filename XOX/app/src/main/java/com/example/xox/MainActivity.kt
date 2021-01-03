package com.example.xox

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var oyuncu1 = ArrayList<Int>()
    var oyuncu2 = ArrayList<Int>()
    var hamleYapanOyuncu = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sayi = 1

        btn1.setOnClickListener {
           if (sayi%2==1){
               btn1.text = "X"
               oyuncu1.add(1)
           }else{
               btn1.text = "O"
               oyuncu2.add(1)
           }
            kontrol()
            sayi++
            btn1.isEnabled=false
        }

        btn2.setOnClickListener {
            if (sayi%2==1){
                btn2.text = "X"
                oyuncu1.add(2)
            }else{
                btn2.text = "O"
                oyuncu2.add(2)
            }
            kontrol()
            sayi++
            btn2.isEnabled=false
        }
        btn3.setOnClickListener {
            if (sayi%2==1){
                btn3.text = "X"
                oyuncu1.add(3)
            }else{
                btn3.text = "O"
                oyuncu2.add(3)
            }
            kontrol()
            sayi++
            btn3.isEnabled=false

        }
        btn4.setOnClickListener {
            if (sayi%2==1){
                btn4.text = "X"
                oyuncu1.add(4)
            }else{
                btn4.text = "O"
                oyuncu2.add(4)
            }
            kontrol()
            sayi++
            btn4.isEnabled=false

        }
        btn5.setOnClickListener {
            if (sayi%2==1){
                btn5.text = "X"
                oyuncu1.add(5)
            }else{
                btn5.text = "O"
                oyuncu2.add(5)
            }
            kontrol()
            sayi++
            btn5.isEnabled=false
        }
        btn6.setOnClickListener {
            if (sayi%2==1){
                btn6.text = "X"
                oyuncu1.add(6)
            }else{
                btn6.text = "O"
                oyuncu2.add(6)
            }
            kontrol()
            sayi++
            btn6.isEnabled=false

        }
        btn7.setOnClickListener {
            if (sayi%2==1){
                btn7.text = "X"
                oyuncu1.add(7)
            }else{
                btn7.text = "O"
                oyuncu2.add(7)
            }
            kontrol()
            sayi++
            btn7.isEnabled=false

        }
        btn8.setOnClickListener {
            if (sayi%2==1){
                btn8.text = "X"
                oyuncu1.add(8)
            }else{
                btn8.text = "O"
                oyuncu2.add(8)
            }
            kontrol()
            sayi++
            btn8.isEnabled=false

        }
        btn9.setOnClickListener {
            if (sayi%2==1){
                btn9.text = "X"
                oyuncu1.add(9)
            }else{
                btn9.text = "O"
                oyuncu2.add(9)
            }
            kontrol()
            sayi++
            btn9.isEnabled=false
        }

        btnReset.setOnClickListener {
            oyuncu1.clear()
            oyuncu2.clear()
            tvSira.text=""
            sayi = 1
            btn1.text=""
            btn1.isEnabled = true
            btn2.text=""
            btn2.isEnabled = true
            btn3.text=""
            btn3.isEnabled = true
            btn4.text=""
            btn4.isEnabled = true
            btn5.text=""
            btn5.isEnabled = true
            btn6.text=""
            btn6.isEnabled = true
            btn7.text=""
            btn7.isEnabled = true
            btn8.text=""
            btn8.isEnabled = true
            btn9.text=""
            btn9.isEnabled = true
        }


    }



    fun kontrol(){
        var kazanan = -1
        // 1. satır kontrolu
        if (oyuncu1.contains(1)&&oyuncu1.contains(2)&&oyuncu1.contains(3)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(1)&&oyuncu2.contains(2)&&oyuncu2.contains(3)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }

        // 2. satır kontrolu
        if (oyuncu1.contains(4)&&oyuncu1.contains(5)&&oyuncu1.contains(6)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(4)&&oyuncu2.contains(5)&&oyuncu2.contains(6)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }

        // 3. satir kontrolu
        if (oyuncu1.contains(7)&&oyuncu1.contains(8)&&oyuncu1.contains(9)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(7)&&oyuncu2.contains(8)&&oyuncu2.contains(9)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }

        // 1. sutun kontrol

        if (oyuncu1.contains(1)&&oyuncu1.contains(4)&&oyuncu1.contains(7)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(1)&&oyuncu2.contains(4)&&oyuncu2.contains(7)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }

        // 2. sutun
        if (oyuncu1.contains(2)&&oyuncu1.contains(5)&&oyuncu1.contains(8)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(2)&&oyuncu2.contains(5)&&oyuncu2.contains(8)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }

        // 3. sutun kontrol

        if (oyuncu1.contains(3)&&oyuncu1.contains(6)&&oyuncu1.contains(9)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(3)&&oyuncu2.contains(6)&&oyuncu2.contains(9)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }


        // sag capraz

        if (oyuncu1.contains(1)&&oyuncu1.contains(5)&&oyuncu1.contains(9)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(1)&&oyuncu2.contains(5)&&oyuncu2.contains(9)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }


        // sol capraz

        if (oyuncu1.contains(3)&&oyuncu1.contains(5)&&oyuncu1.contains(7)){
            kazanan = 1
            tvSira.text = "Oyuncu 1 Kazandı!"
        }
        if (oyuncu2.contains(3)&&oyuncu2.contains(5)&&oyuncu2.contains(7)){
            kazanan = 2
            tvSira.text = "Oyuncu 2 Kazandı!"
        }


        if (kazanan == -1){
            tvSira.text = "Berabere"
        }



    }


}
