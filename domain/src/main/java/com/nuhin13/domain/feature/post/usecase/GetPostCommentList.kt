package com.nuhin13.domain.feature.post.usecase

import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.repository.PostRepository
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostCommentList @Inject constructor(private val postRepository: PostRepository) {
    suspend fun getPostCommentList(postId: String): Flow<DataResult<PostCommentList>> {
        return postRepository.getPostCommentList(postId)
    }
}