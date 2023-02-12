package com.example.tensor_api_edo.domain.model_bl


import android.os.Parcelable
import com.example.tensor_api_edo.domain.model_bl.Attachment
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Document(
    val id : String,
    val name : String,
    val nomber: String,
    val direction: String,
    val Subtype: String,
    var attachments : MutableList<Attachment>,
    val sum: String,
    val type: String,
    val data : String,
    val status : String,
    val partner : String
) : Parcelable
