package com.example.tensor_api_edo.data.document_model

import kotlinx.android.parcel.Parcelize


data class Реестр(
    val ДатаВремя: String,
    val Документ: Документ,
    val Состояние: СостояниеX
)