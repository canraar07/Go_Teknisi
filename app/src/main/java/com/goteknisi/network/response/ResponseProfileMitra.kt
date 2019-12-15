package com.goteknisi.network.response

import com.google.gson.annotations.SerializedName
import com.goteknisi.network.model.ProfileMitraModel

data class ResponseProfileMitra (
    @SerializedName("status")
    val status : String? = null,
    @SerializedName("result")
    val result : ArrayList<ProfileMitraModel>
)