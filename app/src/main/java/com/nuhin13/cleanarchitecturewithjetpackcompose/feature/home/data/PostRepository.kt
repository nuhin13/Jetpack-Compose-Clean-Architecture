package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.data

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.api.ApiService
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPostList(): PostApiResponse {
        return apiService.getPostList()
    }
}