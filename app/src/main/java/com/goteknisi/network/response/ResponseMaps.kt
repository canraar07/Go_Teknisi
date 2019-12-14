package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ResponseModelMaps

data class ResponseMaps (
    @SerializedName("status")
    val status : String? = null,
    @SerializedName("result")
    val result : ArrayList<ResponseModelMaps>
)