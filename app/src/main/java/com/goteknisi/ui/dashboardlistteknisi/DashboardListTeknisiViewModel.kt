package com.goteknisi.ui.dashboardlistteknisi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseKerusakan
import com.goteknisi.network.response.ResponseListMitra
import com.goteknisi.utils.DataKerusakan
import com.goteknisi.utils.Datalis
import retrofit2.Call
import retrofit2.Response

class DashboardListTeknisiViewModel : ViewModel() {
    var listdata = MutableLiveData<ArrayList<Datalis>>()
    fun getListMitra(){
        val listmitra = ArrayList<Datalis>()
        BaseApi.creatService(ApiendPoint::class.java)
            .getListMitra()
            .enqueue(object : retrofit2.Callback<ResponseListMitra>{

                override fun onResponse(
                    call: Call<ResponseListMitra>,
                    response: Response<ResponseListMitra>
                ) {
                    response.let {it ->
                        if(response.isSuccessful){
                            it.body()?.let {
                                val res = it.item?.indices
                                if(res != null){
                                    for(i in res){
                                        val kodemitra = it.item[i].kodemitra
                                        val namamitra = it.item[i].namamitra
                                        val image = it.item[i].image
                                        listmitra.add(Datalis(namamitra,image,kodemitra.toString()))
                                    }
                                }
                                listdata.postValue(listmitra)
                            }
                        }else{
                            Log.e("eror","response gagal")
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseListMitra>, t: Throwable) {
                    Log.e("eror",t.toString())
                }

            })
    }

    fun getData(): LiveData<ArrayList<Datalis>> {
        Log.e("datanya",listdata.toString())
        return listdata
    }
}
