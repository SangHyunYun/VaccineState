package com.shyun.mybottomnavigation.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object RetrofitService {
    private const val BASE_URL = "https://api.odcloud.kr/"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun getClient(): OkHttpClient {
       return OkHttpClient.Builder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(5L, TimeUnit.SECONDS)
            readTimeout(20L, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    val vaccineService: VaccineService by lazy {
        retrofitService().create(VaccineService::class.java)
    }
}