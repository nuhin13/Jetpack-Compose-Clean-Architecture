package com.nuhin13.data.features.user.datasource

import com.nuhin13.data.features.user.dtos.UserApiResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("v1/user")
    suspend fun getUsersList(): UserApiResponse
}