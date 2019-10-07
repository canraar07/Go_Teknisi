package com.goteknisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bLogin.setOnClickListener {
            val intent = Intent(this,DashboarCusActivity::class.java)
            startActivity(intent)
        }
        bRegis.setOnClickListener {
            val intent = Intent(this,RegisActivity::class.java)
            startActivity(intent)
        }
    }
}
