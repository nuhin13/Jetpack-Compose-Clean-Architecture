package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.data

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.di.network.RetrofitInstance

class PostRepository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getPostList(): PostApiResponse {
        return apiService.getPostList()
    }
}