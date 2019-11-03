package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.ui.teknisidetail.TeknisiDetailFragment

class TeknisiDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teknisi_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TeknisiDetailFragment.newInstance())
                .commitNow()
        }
    }

}
