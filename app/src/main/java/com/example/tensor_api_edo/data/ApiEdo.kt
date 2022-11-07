package com.example.tensor_api_edo.data

import com.example.tensor_api_edo.data.Authenticate.AnswerAuthenticate
import com.example.tensor_api_edo.data.Authenticate.qest.QestionAuthenticate
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiEdo {

    @POST("auth/service/")
    @Headers("Content-Type: application/json-rpc;charset=utf-8")
    fun Authenticate(@Body body : QestionAuthenticate): Single<AnswerAuthenticate>




}