package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.ui.jeniskerusakan.JenisKerusakanFragment

class JenisKerusakanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jenis_kerusakan_activity)
        var nama = intent.getStringExtra("nama")
        var notlp = intent.getStringExtra("notlp")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, JenisKerusakanFragment.newInstance(
                    nama,
                    notlp
                ))
                .commitNow()
        }
    }

}
