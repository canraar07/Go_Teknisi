package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.goteknisi.ui.dashboarcus.DashboarCusFragment

class DashboarCusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboar_cus_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboarCusFragment.newInstance())
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menuheader,menu)
        return true
    }

}
