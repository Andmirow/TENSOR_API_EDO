package com.example.tensor_api_edo.domain

import com.example.tensor_api_edo.data.document_model.Файл

data class Document(
    val id : String,
    val name : String,
    val nomber: String,
    val Direction: String,
    val Subtype: String,
    val HTML: String,
    val Sum: String,
    val Type: String
)
