package com.goteknisi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseProfileMitra
import kotlinx.android.synthetic.main.activity_profile_teknisi.*
import retrofit2.Call
import retrofit2.Response

class ProfileTeknisiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_teknisi)
        val kodemitra = intent.getStringExtra("kodemitra")
        progressBar5.isVisible=false
        imageProfile.isVisible=false
        textNmamatekprofile.isVisible=false
        textKeahlian.isVisible=false
        getProfileMitra(kodemitra,this)
    }

    fun getProfileMitra(kodemitra : String?,context: Context){
        progressBar5.isVisible=true
        BaseApi.creatService(ApiendPoint::class.java)
            .getProfileMitra(kodemitra)
            .enqueue(object : retrofit2.Callback<ResponseProfileMitra>{
                override fun onFailure(call: Call<ResponseProfileMitra>, t: Throwable) {

                    progressBar5.isVisible=false
                    Toast.makeText(context,"Gagagal",Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<ResponseProfileMitra>,
                    response: Response<ResponseProfileMitra>
                ) {

                    progressBar5.isVisible=false
                    response.let {
                        if(response.isSuccessful){
                            it.body().let {
                                val status = it!!.status
                                if(status == "sukses"){
                                    val res = it.result
                                    Glide.with(context)
                                        .load(res[0].image)
                                        .into(imageProfile)
                                    textNmamatekprofile.text=res[0].namamitra
                                    textKeahlian.text=res[0].keahlian
                                    progressBar5.isVisible=false
                                    imageProfile.isVisible=false
                                    textNmamatekprofile.isVisible=false
                                    textKeahlian.isVisible=false
                                }else{
                                    Toast.makeText(context,"Gagagal",Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                        }else{

                        }
                    }
                }

            })
    }
}
