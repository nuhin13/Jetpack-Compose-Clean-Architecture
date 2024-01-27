package com.nuhin13.data.api

import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.data.features.user.dtos.UserApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/post")
    suspend fun getPostList(): PostApiResponse

    @GET("v1/user")
    suspend fun getUsersList(): UserApiResponse

    @GET("v1/post/{post_id}/comment")
    suspend fun getPostComments(@Path("post_id") postId: String): PostCommentApiResponse
}