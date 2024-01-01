package com.nuhin13.cleanarchitecturewithjetpackcompose.di.network

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val BASE_URL = "https://dummyapi.io/data/"

    private val retrofit: Retrofit by lazy {

        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("app-id", "657eef24ed571a529367f1be")
                    .build()
                chain.proceed(request)
            }

        val okHttpClient1 = builder.build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient1)
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
