package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.ui.order.OrderFragment

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OrderFragment.newInstance())
                .commitNow()
        }
    }

}
