package com.example.tensor_api_edo.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InnerFile(
    val name :String,
    val data : ByteArray?
): Parcelable
