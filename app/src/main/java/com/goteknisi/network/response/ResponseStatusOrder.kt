package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ResponseModelStatusOrder

data class ResponseStatusOrder (
    @SerializedName("status")
    val status : String? = null,
    @SerializedName("result")
    val result : ArrayList<ResponseModelStatusOrder>
)