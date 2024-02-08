package com.nuhin13.domain.feature.post.repository

import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPostList(): Flow<DataResult<PostItemList>>
    suspend fun getPostCommentList(postId: String): Flow<DataResult<PostCommentList>>
}