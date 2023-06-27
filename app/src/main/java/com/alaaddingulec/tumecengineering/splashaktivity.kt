package com.alaaddingulec.tumecengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splashaktivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashaktivity)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent =Intent(this@splashaktivity,MainActivity::class.java)
            startActivity(intent)
            finish()

        },2000)


        }
    }
