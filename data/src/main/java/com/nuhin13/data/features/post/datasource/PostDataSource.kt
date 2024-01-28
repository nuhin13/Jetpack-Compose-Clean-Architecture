package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse

interface PostDataSource {
    suspend fun getPostList(): PostApiResponse
    suspend fun getPostCommentList(postId:String): PostCommentApiResponse
}