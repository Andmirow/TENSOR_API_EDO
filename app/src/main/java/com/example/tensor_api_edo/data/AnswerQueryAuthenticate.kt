package com.example.tensor_api_edo.data

import com.example.tensor_api_edo.data.document_model.Реестр

data class AnswerQueryAuthenticate(
    val id: Int,
    val jsonrpc: String,
    val result: Any//Result<Реестр>
)