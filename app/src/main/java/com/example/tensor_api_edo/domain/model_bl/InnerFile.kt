package com.example.tensor_api_edo.domain.model_bl

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InnerFile(
    val nameFile : String,
    val xml : ByteArray?,
    val hashXml : ByteArray?
): Parcelable
