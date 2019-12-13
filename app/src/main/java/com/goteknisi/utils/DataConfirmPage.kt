package com.goteknisi.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataConfirmPage (
    val namateknisi : String? = null,
    val namacus : String? = null,
    val nocus : String? = null,
    val tgl : String? = null,
    val almt : String? = null,
    val kerusakan : ArrayList<DatakerusakanCus>? = null,
    val kodemitra : String? = null,
    val idcus : String? = null
) : Parcelable