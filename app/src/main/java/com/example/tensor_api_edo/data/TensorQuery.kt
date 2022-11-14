package com.example.tensor_api_edo.data

data class TensorQuery(
    val id: Int = 0,
    val jsonrpc: String = "2.0",
    val method: String,
    val params: Any
)