package com.example.tensor_api_edo.data.document_model

data class Контрагент(
    val Email: String,
    val ИдентификаторИС: String,
    val ИдентификаторСПП: String,
    val Описание: String,
    val СвЮЛ: СвЮЛ,
    val Телефон: String
)