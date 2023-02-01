package com.example.tensor_api_edo.domain


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Document(
    val id : String,
    val name : String,
    val nomber: String,
    val direction: String,
    val Subtype: String,
    val lincksOfHTML : MutableMap<String, String>,
    var files : MutableList<InnerFile>, //MutableMap<String, ByteArray>,

    val sum: String,
    val type: String,
    val data : String,
    val status : String,
    val partner : String
) : Parcelable
