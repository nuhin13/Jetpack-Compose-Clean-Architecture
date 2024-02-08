package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    suspend fun getPostList(): Flow<DataResult<PostApiResponse>?>
    suspend fun getPostCommentList(postId:String): Flow<DataResult<PostCommentApiResponse>?>
}