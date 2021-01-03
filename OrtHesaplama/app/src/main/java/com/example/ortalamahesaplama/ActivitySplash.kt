package com.example.ortalamahesaplama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

      var homeButon = AnimationUtils.loadAnimation(this,R.anim.asagidangelenikon)
        btnStart.animation = homeButon

       var balon = AnimationUtils.loadAnimation(this,R.anim.yukaridangelenikon)
        ivBalloon.animation = balon

        var yukariBalon = AnimationUtils.loadAnimation(this,R.anim.yukariyagiden)
        var asagihome = AnimationUtils.loadAnimation(this,R.anim.asagigiden)

        btnStart.setOnClickListener {
           btnStart.startAnimation(asagihome)
            ivBalloon.startAnimation(yukariBalon)

            object : CountDownTimer(1500,1500){
                override fun onFinish() {
                    var intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }

                override fun onTick(p0: Long) {
                }

            }.start()

        }

    }
}
