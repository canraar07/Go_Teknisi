package com.goteknisi.ui.dashboarcus

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.SupportMapFragment
import com.goteknisi.R
import com.goteknisi.adapter.AdapterStatusOrder
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseStatusOrder
import com.goteknisi.utils.DataStatusOrder
import kotlinx.android.synthetic.main.fragment_halaman_booking_customer.*
import retrofit2.Call
import retrofit2.Response

class HalamanBookingCustomer : Fragment() {

    companion object {
        fun newInstance() = HalamanBookingCustomer()
        fun newInstance(
            idcus: String?
        ) : HalamanBookingCustomer{
            val fragment = HalamanBookingCustomer()
            val bundle = Bundle().apply {
                putString("idcus",idcus)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_halaman_booking_customer, container, false)
    }
    lateinit var adapter: AdapterStatusOrder
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val idcus = arguments!!.getString("idcus")
        adapter = AdapterStatusOrder()
        recyleBooking.layoutManager = LinearLayoutManager(this.context)
        this.context?.let { getOrderStatus(idcus, it) }
    }

    fun getOrderStatus(idcus : String?,context: Context){
        val listData = ArrayList<DataStatusOrder>()
        adapter.dataClear()
        BaseApi.creatService(ApiendPoint::class.java)
            .StatusOrder(idcus)
            .enqueue(object : retrofit2.Callback<ResponseStatusOrder>{
                override fun onFailure(call: Call<ResponseStatusOrder>, t: Throwable) {
                    Toast.makeText(context,"gagal",Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<ResponseStatusOrder>,
                    response: Response<ResponseStatusOrder>
                ) {
                    response.let {
                        if(response.isSuccessful){
                            it.body().let {
                                val status = it!!.status
                                if(status == "sukses"){
                                    val res = it.result
                                    for(i in res.indices){
                                        val namatek = res[i].namatek
                                        val namacus = res[i].namacus
                                        val invoice = res[i].invoice
                                        val tglperbaikan = res[i].tglperbaikan
                                        val alamatcus = res[i].alamatcus
                                        val jeniskerusakan = res[i].jeniskerusakan
                                        val codeteknisi = res[i].codeteknisi
                                        val idcustomer = res[i].idcustomer
                                        val nocus = res[i].nocus
                                        val statusorder = res[i].statusorder
                                        listData.add(DataStatusOrder(
                                            namatek,
                                            namacus,
                                            invoice,
                                            tglperbaikan,
                                            alamatcus,
                                            jeniskerusakan,
                                            codeteknisi,
                                            idcustomer,
                                            nocus,
                                            statusorder
                                        ))
                                    }
                                    adapter.setData(listData)
                                    recyleBooking.adapter = adapter
                                }else{

                                }
                            }
                        }
                    }
                }

            })
    }
}
