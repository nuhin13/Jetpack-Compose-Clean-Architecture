package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import javax.inject.Inject

class PostHttpImpl @Inject constructor(private val apiService: ApiService) :
    PostDataSource {
    override suspend fun getPostList(): PostApiResponse {
        return apiService.getPostList()
    }

    override suspend fun getPostCommentList(postId:String): PostCommentApiResponse {
        return apiService.getPostComments(postId)
    }
}