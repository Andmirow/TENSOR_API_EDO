package com.example.tensor_api_edo.data.document_model

data class НашаОрганизация(
    val ИдентификаторИС: String,
    val ИдентификаторСПП: String,
    val ПодписаниеОграничено: String,
    val СвЮЛ: СвЮЛ
)