package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ProfileMitraModel (
    @SerializedName("kodemitra")
    val kodemitra : String? = null,
    @SerializedName("namamitra")
    val namamitra : String? = null,
    @SerializedName("alamat")
    val alamat : String? = null,
    @SerializedName("nomortlp")
    val nomortlp : String? = null,
    @SerializedName("keahlian")
    val keahlian : String? = null,
    @SerializedName("rating")
    val rating : String? = null,
    @SerializedName("image")
    val image : String? = null
)