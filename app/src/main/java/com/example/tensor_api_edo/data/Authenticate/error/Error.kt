package com.example.tensor_api_edo.data.Authenticate.error

import com.example.tensor_api_edo.data.Authenticate.error.Data

data class Error(
    val code: Int,
    val `data`: Data,
    val details: String,
    val message: String
)