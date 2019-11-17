package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ResponseModelKerusakan (
    @SerializedName("kerusakan")
    val kerusakan: String?,

    @SerializedName("type")
    val type: String?
)