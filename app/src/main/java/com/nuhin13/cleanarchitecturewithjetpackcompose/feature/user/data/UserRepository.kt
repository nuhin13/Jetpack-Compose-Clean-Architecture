package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.data

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.UserApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.di.network.RetrofitInstance

class UserRepository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getUserList(): UserApiResponse {
        return apiService.getUsersList()
    }
}