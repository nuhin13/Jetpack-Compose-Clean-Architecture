package com.nuhin13.cleanarchitecturewithjetpackcompose.data.api

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostCommentApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.UserApiResponse
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