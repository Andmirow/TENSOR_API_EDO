package com.example.tensor_api_edo.data

import io.reactivex.Single
import retrofit2.http.*

interface ApiEdo {

    @POST("auth/service/")
    @Headers("Content-Type: application/json-rpc;charset=utf-8")
    fun Authenticate(@Body body : TensorQuery): Single<AnswerQueryAuthenticate>


    @POST("service/?srv=1/")
    @Headers("Content-Type: application/json-rpc;charset=utf-8")
    fun getDocumentListForEvent(@Body body : TensorQuery, @Header("X-SBISSessionID") token : String): Single<AnswerQueryListDocument>




    @GET
    //@Headers("Content-Type: application/json-rpc;charset=windows-1251","Host: disk.sbis.ru")
    fun getFile(@Url url : String, @Header("X-SBISSessionID")token : String) : Single<String>




}