package com.nuhin13.data.di.network

import com.google.gson.Gson
import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.localstorage.datastore.PrefConstant
import com.nuhin13.data.localstorage.datastore.PreferencesDataStore
import com.nuhin13.domain.feature.authentication.entity.UserInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(pref: PreferencesDataStore): OkHttpClient {
        var token: String? = null

        // TODO Refactor this code
        GlobalScope.launch {
            if (pref.getJson(PrefConstant.USER_INFO).isNotEmpty()) {
                token = Gson().fromJson(
                    pref.getJson(PrefConstant.USER_INFO),
                    UserInfo::class.java
                )?.token?.appId
            }

            println("token: $token")
        }

        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("app-id", token.toString())
                    .build()
                chain.proceed(request)
            }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyapi.io/data/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}