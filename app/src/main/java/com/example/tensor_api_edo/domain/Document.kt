package com.example.tensor_api_edo.domain


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Document(
    val id : String,
    val name : String,
    val nomber: String,
    val Direction: String,
    val Subtype: String,
    val HTML: String,
    val Sum: String,
    val Type: String,

    val data : String,
    val status : String,
    val partner : String
) : Parcelable
