package com.example.tensor_api_edo.data.Authenticate.qest

data class qestionAuthenticate(
    val id: Int = 0,
    val jsonrpc: String = "2.0",
    val method: String = "СБИС.Аутентифицировать",
    val params: Params
)