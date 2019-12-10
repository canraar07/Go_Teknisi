package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ResponseLoginModel

data class  ResponseLogin (
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("result")
    val item : List<ResponseLoginModel>? = null
)