package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ResponseLoginModel (
    @SerializedName("id")
    val id: String?,
    @SerializedName("alamat")
    val alaamt: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("nama")
    val nama: String
)