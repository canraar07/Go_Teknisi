package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ResponseModelKerusakan

data class ResponseKerusakan (
    @SerializedName("result")
    val itemKerusakan : List<ResponseModelKerusakan>? = null
)