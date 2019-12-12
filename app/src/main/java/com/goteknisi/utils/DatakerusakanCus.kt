package com.goteknisi.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DatakerusakanCus (
    val kerusakan : String? = null,
    val typ : String? = null
) : Parcelable