package com.goteknisi.ui.regis

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseRegis
import retrofit2.Call
import retrofit2.Response

class RegisViewModel : ViewModel() {
    var status = MutableLiveData<String>()
    fun Regis(usr:String?,pswd:String?,almt:String?,name:String?,phone:String?,context: Context?){
        BaseApi.creatService(ApiendPoint::class.java)
            .Regis(usr,pswd,almt,name,phone)
            .enqueue(object : retrofit2.Callback<ResponseRegis>{
                override fun onFailure(call: Call<ResponseRegis>, t: Throwable) {
                    Log.e("eror","Gagal")
                    Toast.makeText(context,"Gagal",Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<ResponseRegis>,
                    response: Response<ResponseRegis>
                ) {
                    response.let {
                        if(response.isSuccessful){
                            it.body().let {
                                val res = it?.status
                                if(res == "sukses"){
                                    Toast.makeText(context,"sukses",Toast.LENGTH_LONG)
                                        .show()
                                    status.postValue("sukses")
                                }else{
                                    Toast.makeText(context,"Gagal",Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                        }

                    }
                }

            })
    }

    fun getStatus() : LiveData<String> {
        return status
    }
}
