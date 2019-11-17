package com.goteknisi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseApi {
    const val BASE_URL: String = "http://mobiletechnet17.000webhostapp.com/"

    fun retrofitInit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> creatService(service: Class<T>): T {
        return retrofitInit()!!.create(service)
    }
}