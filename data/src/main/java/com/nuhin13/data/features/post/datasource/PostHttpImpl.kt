package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.api.ApiService
import com.nuhin13.data.util.toResultFlow
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostHttpImpl @Inject constructor(private val apiService: ApiService) :
    PostDataSource {
    override suspend fun getPostList(): Flow<DataResult<PostApiResponse>?> {
        return toResultFlow { apiService.getPostList() }
    }

    override suspend fun getPostCommentList(postId: String): Flow<DataResult<PostCommentApiResponse>?> {
        return toResultFlow { apiService.getPostComments(postId) }
    }
}