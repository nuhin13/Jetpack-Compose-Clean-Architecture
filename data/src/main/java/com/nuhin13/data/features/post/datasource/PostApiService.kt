package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {
    @GET("v1/post")
    suspend fun getPostList(): Response<PostApiResponse>

    @GET("v1/post/{post_id}/comment")
    suspend fun getPostComments(@Path("post_id") postId: String): PostCommentApiResponse
}