package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.ui.dashboardlistteknisi.DashboardListTeknisiFragment
import com.goteknisi.utils.DataConfirmPage

class DashboardListTeknisiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_list_teknisi_activity)
        val dataKerusakan = intent.getParcelableArrayListExtra<DataConfirmPage>("datakerusakan")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardListTeknisiFragment.newInstance(
                    dataKerusakan
                ))
                .commitNow()
        }
    }

}
