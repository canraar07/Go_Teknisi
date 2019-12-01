package com.goteknisi.network

import com.goteknisi.network.response.ResponseKerusakan
import com.goteknisi.network.response.ResponseListMitra
import retrofit2.Call
import retrofit2.http.GET

interface ApiendPoint {
    @GET("kerusakan.php")
    fun getListKerusakan(): Call<ResponseKerusakan>

    @GET("listmitra.php")
    fun getListMitra(): Call<ResponseListMitra>
}