package com.goteknisi.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataConfirmPage (
    val tgl : String? = null,
    val almt : String? = null,
    val kerusakan : ArrayList<DatakerusakanCus>? = null
) : Parcelable