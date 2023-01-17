package com.example.tensor_api_edo.data

import com.example.tensor_api_edo.domain.SbisSetting
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiEdo {

    @POST("auth/service/")
    @Headers("Content-Type: application/json-rpc;charset=utf-8")
    fun Authenticate(@Body body : TensorQuery): Single<AnswerQuery>


    @POST("service/?srv=1/")
    @Headers("Content-Type: application/json-rpc;charset=utf-8")
    fun getDocumentListForEvent(@Body body : TensorQuery, @Header("X-SBISSessionID") token : String): Single<AnswerQuery>



}