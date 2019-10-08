package com.goteknisi

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bLogin.setOnClickListener {
            val intent = Intent(this, DashboarCusActivity::class.java)
            startActivity(intent)
        }
        bRegis.setOnClickListener {
            val intent = Intent(this, RegisActivity::class.java)
            startActivity(intent)
        }
        methodWithPermissions()
    }

    fun methodWithPermissions() = runWithPermissions(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) {
        Toast.makeText(this, "Akses Lokasi Di Berikan", Toast.LENGTH_SHORT).show();
        // Do the stuff with permissions safely
    }
}
