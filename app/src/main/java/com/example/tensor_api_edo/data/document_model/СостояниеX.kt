package com.example.tensor_api_edo.data.document_model

import kotlinx.android.parcel.Parcelize


data class СостояниеX(
    val Код: String,
    val Название: String,
    val НеполнаяОбработка: String,
    val Описание: String,
    val Примечание: String,
    val Сложное: String
)