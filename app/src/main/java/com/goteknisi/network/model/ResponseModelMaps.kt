package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ResponseModelMaps (
    @SerializedName("nama_toko")
    val nama_toko : String? = null,
    @SerializedName("lat")
    val lat : String? = null,
    @SerializedName("lang")
    val lang : String? = null
)