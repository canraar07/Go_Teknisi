package com.goteknisi.network.model

import com.google.gson.annotations.SerializedName

data class ResponseModelStatusOrder (
    @SerializedName("namatek")
    val namatek : String? = null,
    @SerializedName("namacus")
    val namacus : String? = null,
    @SerializedName("invoice")
    val invoice : String? = null,
    @SerializedName("tglperbaikan")
    val tglperbaikan : String? = null,
    @SerializedName("alamatcus")
    val alamatcus : String? = null,
    @SerializedName("jeniskerusakan")
    val jeniskerusakan : String? = null,
    @SerializedName("codeteknisi")
    val codeteknisi : String? = null,
    @SerializedName("idcustomer")
    val idcustomer : String? = null,
    @SerializedName("nocus")
    val nocus : String? = null,
    @SerializedName("statusorder")
    val statusorder: String? = null
)