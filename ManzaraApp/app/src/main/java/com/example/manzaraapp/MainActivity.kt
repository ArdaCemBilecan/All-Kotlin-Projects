package com.example.manzaraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumManzaralar = ArrayList<Manzara>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiOlsutur()

        var myAdapter = ManzaraAdapter(tumManzaralar)
        recyclerViewManzara.adapter = myAdapter

     var linearLayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerViewManzara.layoutManager = linearLayoutManager as LayoutManager?

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.anamenu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.itemId

        when(id){
            R.id.biltekHaber ->{
                var linearLayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
                recyclerViewManzara.layoutManager = linearLayoutManager
            }
            R.id.biltekGrup -> {
                var gridLayoutManager = GridLayoutManager(this,2)
                recyclerViewManzara.layoutManager = gridLayoutManager
            }

        }
      return super.onOptionsItemSelected(item)
    }


    fun veriKaynagiOlsutur(): ArrayList<Manzara>{

        var tumResimler = arrayOf(R.drawable.manzara1,R.drawable.manzara2,R.drawable.manzara3,R.drawable.manzara4,
            R.drawable.manzara5,R.drawable.manzara6,R.drawable.manzara7,R.drawable.manzara8,R.drawable.manzara9,R.drawable.manzara10)


        for (i in 0..tumResimler.size-1){
            var eklenecekManzara=Manzara("Baslik" + i,"Açıklama" +i ,tumResimler[i])
            tumManzaralar.add(eklenecekManzara)
        }
     return tumManzaralar
    }

}
