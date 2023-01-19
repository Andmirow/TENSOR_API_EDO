package com.example.tensor_api_edo.data

import com.example.tensor_api_edo.data.document_model.Result

data class AnswerQueryListDocument(
    val id: Int,
    val jsonrpc: String,
    val result: Result
)