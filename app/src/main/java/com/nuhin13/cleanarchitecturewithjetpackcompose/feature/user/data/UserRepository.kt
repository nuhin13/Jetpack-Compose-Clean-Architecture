package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.data

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.api.ApiService
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.UserApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.di.network.RetrofitInstance
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getUserList(): UserApiResponse {
        return apiService.getUsersList()
    }
}