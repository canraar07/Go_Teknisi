package com.goteknisi.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataDetailStatusOrder (
    val namatek : String? = null,
    val namacus : String? = null,
    val invoice : String? = null,
    val tglperbaikan : String? = null,
    val alamatcus : String? = null,
    val jeniskerusakan : String? = null,
    val codeteknisi : String? = null,
    val idcustomer : String? = null,
    val nocus : String? = null,
    val statusorder: String? = null
): Parcelable