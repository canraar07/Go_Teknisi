package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.ui.confirmasikerusakan.ConfirmasiKerusakanFragment

class ConfirmasiKerusakan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmasi_kerusakan_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConfirmasiKerusakanFragment.newInstance())
                .commitNow()
        }
    }

}
