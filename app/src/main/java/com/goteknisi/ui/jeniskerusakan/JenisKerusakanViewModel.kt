package com.goteknisi.ui.jeniskerusakan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseKerusakan
import com.goteknisi.utils.DataKerusakan
import retrofit2.Call
import retrofit2.Response

class JenisKerusakanViewModel : ViewModel() {

    var listdata = MutableLiveData<ArrayList<DataKerusakan>>()

    fun getKerusakanList() {
        val listKerusakan = ArrayList<DataKerusakan>()
        BaseApi.creatService(ApiendPoint::class.java)
            .getListKerusakan()
            .enqueue(object : retrofit2.Callback<ResponseKerusakan>{

                override fun onResponse(
                    call: Call<ResponseKerusakan>,
                    response: Response<ResponseKerusakan>
                ) {
                   response.let {it ->
                       if(response.isSuccessful){
                           it.body()?.let {
                               val res = it.itemKerusakan?.indices
                               if(res != null){
                                   for(i in res){
                                       val kerusakan = it.itemKerusakan[i].kerusakan
                                       val type = it.itemKerusakan[i].type
                                       listKerusakan.add(
                                           DataKerusakan(
                                               kerusakan,
                                               type
                                           )
                                       )
                                   }
                               }
                               listdata.postValue(listKerusakan)
                           }
                       }else{
                           Log.e("eror","response gagal")
                       }
                   }
                    //Log.e("",listKerusakan.toString())

                }

                override fun onFailure(call: Call<ResponseKerusakan>, t: Throwable) {
                    Log.e("eror",t.toString())
                }

            })
    }

    fun getData(): LiveData<ArrayList<DataKerusakan>>{
        Log.e("datanya",listdata.toString())
        return listdata
    }
}
