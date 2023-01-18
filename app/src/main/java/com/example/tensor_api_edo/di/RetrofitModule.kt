package com.example.tensor_api_edo.di


import com.example.tensor_api_edo.data.ApiEdo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRxJava2CallAdapter() : RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    @Provides
    fun provideRetrofit(
        gsonConverter: GsonConverterFactory,
        httpClient : OkHttpClient,
        RxJava2CallAdapter : RxJava2CallAdapterFactory
    ) : Retrofit
        = Retrofit.Builder()
            .baseUrl("https://fix-online.sbis.ru/")
            .addConverterFactory(gsonConverter)
            .addCallAdapterFactory(RxJava2CallAdapter)
            .client(httpClient)
            .build()


    @Provides
    fun provideApiEdo(retrofit : Retrofit) : ApiEdo = retrofit.create(ApiEdo::class.java)


}