package com.nuhin13.domain.feature.post.usecase

import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.repository.PostRepository
import javax.inject.Inject

class GetPostCommentList @Inject constructor(private val postRepository: PostRepository) {
    suspend fun getPostCommentList(postId: String): PostCommentList {
        return postRepository.getPostCommentList(postId)
    }
}