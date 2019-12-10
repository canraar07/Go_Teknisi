package com.goteknisi.network

import com.goteknisi.network.response.ResponseKerusakan
import com.goteknisi.network.response.ResponseListMitra
import com.goteknisi.network.response.ResponseLogin
import com.goteknisi.network.response.ResponseRegis
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiendPoint {
    @GET("kerusakan.php")
    fun getListKerusakan(): Call<ResponseKerusakan>

    @GET("listmitra.php")
    fun getListMitra(): Call<ResponseListMitra>

    @GET("login.php")
    fun Login(
        @Query("username") username : String?,
        @Query("password") password : String?
    ): Call<ResponseLogin>

    @GET("regis.php")
    fun Regis(
        @Query("username") username : String?,
        @Query("password") password : String?,
        @Query("alamat") alamat : String?,
        @Query("nama") nama : String?,
        @Query("phone") phone : String?
    ): Call<ResponseRegis>

}