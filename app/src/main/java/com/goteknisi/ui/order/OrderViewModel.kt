package com.goteknisi.ui.order

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseOrder
import com.goteknisi.utils.DataConfirmPage
import retrofit2.Call
import retrofit2.Response

class OrderViewModel : ViewModel() {
    var status = MutableLiveData<ArrayList<String>>()
    fun Order( dataOrder : ArrayList<DataConfirmPage>?){
        BaseApi.creatService(ApiendPoint::class.java)
            .Order(dataOrder?.get(0)?.namateknisi,dataOrder?.get(0)?.namacus,dataOrder?.get(0)?.tgl,
                dataOrder?.get(0)?.almt,dataOrder?.get(0)?.kerusakan.toString(),dataOrder?.get(0)?.kodemitra,
                dataOrder?.get(0)?.idcus)
            .enqueue(object : retrofit2.Callback<ResponseOrder>{
                override fun onFailure(call: Call<ResponseOrder>, t: Throwable) {
                    Log.e("eror","Gagal")
                }

                override fun onResponse(
                    call: Call<ResponseOrder>,
                    response: Response<ResponseOrder>
                ) {
                    response.let {
                        if(response.isSuccessful){
                            it.body().let {
                                val res = it?.status
                                if(res == "sukses"){
                                    val ress = ArrayList<String>()
                                    ress.add(res)
                                    it?.invoice?.let { it1 -> ress.add(it1) }
                                    status.postValue(ress)
                                }
                            }
                        }else{

                        }
                    }
                }

            })
    }

    fun getStatus() : LiveData<ArrayList<String>> {
        return status
    }
}
