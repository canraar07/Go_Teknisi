package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ResponseModelMitra (
    @SerializedName("kodemitra")
    val kodemitra: String?,

    @SerializedName("namamitra")
    val namamitra: String?,

    @SerializedName("alamat")
    val alamat: String?,

    @SerializedName("nomortlp")
    val nomortlp: String?,

    @SerializedName("keahlian")
    val keahlian: String?,

    @SerializedName("rating")
    val rating: String?,

    @SerializedName("image")
    val image: String?
)