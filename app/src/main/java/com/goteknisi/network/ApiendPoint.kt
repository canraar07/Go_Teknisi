package com.goteknisi.network

import com.goteknisi.network.response.*
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

    @GET("bookingOrder.php")
    fun Order(
        @Query("namatek") namatek : String?,
        @Query("namacus") namacus : String?,
        @Query("tglperbaikan") tglperbaikan : String?,
        @Query("alamatcus") alamatcus : String?,
        @Query("jeniskerusakan") jeniskerusakan: String?,
        @Query("codeteknisi") codeteknisi : String?,
        @Query("idcustomer") idcustomer : String?,
        @Query("nocus") nocus : String?
    ): Call<ResponseOrder>

    @GET("statusOrder.php")
    fun StatusOrder(
        @Query("idcustomer") idcustomer : String?
    ): Call<ResponseStatusOrder>

}