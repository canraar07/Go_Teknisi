package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ResponseModelMitra

data class ResponseListMitra (
    @SerializedName("result")
    val item : List<ResponseModelMitra>? = null
)