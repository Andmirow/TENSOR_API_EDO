package com.example.tensor_api_edo.domain.model_bl

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attachment(
    val name :String,
    val linckOfHtml : String?,
    val html : ByteArray?,
    val linckOfXml : String?,
    val file: InnerFile,
    val isFormalized : Boolean
): Parcelable
