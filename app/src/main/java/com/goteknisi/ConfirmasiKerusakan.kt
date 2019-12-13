package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.goteknisi.ui.confirmasikerusakan.ConfirmasiKerusakanFragment
import com.goteknisi.utils.DatakerusakanCus

class ConfirmasiKerusakan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmasi_kerusakan_activity)
        val arrkerusakan = intent.getParcelableArrayListExtra<DatakerusakanCus>("arrkerusakan")
        val nama = intent.getStringExtra("nama")
        val notlp = intent.getStringExtra("notlp")
        val idcus = intent.getStringExtra("idcus")
        Log.e("Data",arrkerusakan.toString())
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConfirmasiKerusakanFragment.newInstance(
                    arrkerusakan,
                    nama,
                    notlp,
                    idcus
                ))
                .commitNow()
        }
    }

}
