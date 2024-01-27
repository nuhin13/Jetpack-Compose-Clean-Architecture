package com.nuhin13.domain.feature.post.usecase

import com.nuhin13.domain.feature.post.repository.PostRepository
import javax.inject.Inject

class GetPostList @Inject constructor(private val postRepository: PostRepository) {
    fun getPostList() {
        postRepository.getPostList()
    }
}