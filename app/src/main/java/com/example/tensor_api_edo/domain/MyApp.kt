package com.example.tensor_api_edo.domain

import android.app.Application
import com.example.tensor_api_edo.data.ApiEdo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyApp :Application() {

    lateinit var apiEdo: ApiEdo


    override fun onCreate() {
        super.onCreate()

        configureRetrofit()


        val test = ""

    }


    private fun configureRetrofit(){
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(" https://fix-online.sbis.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        apiEdo = retrofit.create(ApiEdo::class.java)

    }


}