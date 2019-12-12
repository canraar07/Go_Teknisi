package com.goteknisi

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseLogin
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = textusername.text
        val password = textuserpassword.text
        val context =  this
        progressBar2.isVisible=false
        bLogin.setOnClickListener {
            progressBar2.isVisible=true
            BaseApi.creatService(ApiendPoint::class.java)
                .Login(username.toString(),password.toString())
                .enqueue(object : retrofit2.Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Toast.makeText(this@MainActivity,"Login Gagal Silahkan Coba Lagi",
                            Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        response.let {
                            if(response.isSuccessful){
                                it.body().let {
                                    val status = it!!.status
                                    if(status == "sukses"){
                                    val res = it!!.item?.indices
                                    if(res != null){
                                        for(i in res){
                                            val id = it.item?.get(i)!!.id
                                            if(id != null){
                                                progressBar2.isVisible=false
                                                val bundle = Bundle()
                                                bundle.putString("nama",it.item[i].nama)
                                                bundle.putString("notlp",it.item[i].phone)
                                                val intent = Intent(context, DashboarCusActivity::class.java)
                                                intent.putExtras(bundle)
                                                startActivity(intent)
                                            }
                                        }
                                    }
                                  }else{
                                        progressBar2.isVisible=false
                                        Toast.makeText(context,"Login Gagal User Id Tidak Ditemukan",
                                            Toast.LENGTH_LONG).show()
                                    }
                                }
                            }else{
                                progressBar2.isVisible=false
                                Toast.makeText(context,"Login Gagal Silahkan Coba Lagi",
                                    Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                })

        }
        bRegis.setOnClickListener {
            val intent = Intent(this, RegisActivity::class.java)
            startActivity(intent)
        }
        methodWithPermissions()
    }

    fun methodWithPermissions() = runWithPermissions(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) {
        Toast.makeText(this, "Akses Lokasi Di Berikan", Toast.LENGTH_SHORT).show();
        // Do the stuff with permissions safely
    }
}
