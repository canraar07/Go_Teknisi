package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName

data class ResponseOrder (
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("invoice")
    val invoice: String? = null
)