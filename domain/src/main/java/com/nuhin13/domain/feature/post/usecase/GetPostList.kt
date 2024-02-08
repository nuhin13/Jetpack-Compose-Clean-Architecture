package com.nuhin13.domain.feature.post.usecase

import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.repository.PostRepository
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostList @Inject constructor(private val postRepository: PostRepository) {
    suspend fun getPostList() : Flow<DataResult<PostItemList>> {
        return postRepository.getPostList()
    }
}