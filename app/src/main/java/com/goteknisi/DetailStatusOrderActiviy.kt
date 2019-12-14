package com.goteknisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goteknisi.utils.DataDetailStatusOrder
import kotlinx.android.synthetic.main.activity_detail_status_order_activiy.*

class DetailStatusOrderActiviy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_status_order_activiy)
        val detailOrderSt = intent.getParcelableArrayListExtra<DataDetailStatusOrder>("datastorder")
        textNamaCus.text=detailOrderSt[0].namatek
        textAlamat.text=detailOrderSt[0].alamatcus
        textKerusakan.text=detailOrderSt[0].jeniskerusakan
        textNotlp.text=detailOrderSt[0].nocus
        textTgl.text=detailOrderSt[0].tglperbaikan
    }
}
