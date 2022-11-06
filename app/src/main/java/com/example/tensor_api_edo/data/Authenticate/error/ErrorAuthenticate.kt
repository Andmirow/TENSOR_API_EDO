package com.example.tensor_api_edo.data.Authenticate.error

import com.example.tensor_api_edo.data.Authenticate.error.Error

data class ErrorAuthenticate(
    val error: Error,
    val id: Int,
    val jsonrpc: String
)