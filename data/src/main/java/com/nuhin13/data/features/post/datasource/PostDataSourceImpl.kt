package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(private val postHttpImpl: PostHttpImpl) :
    PostDataSource {
    override suspend fun getPostList(): PostApiResponse {
        return postHttpImpl.getPostList()
    }

    override suspend fun getPostCommentList(postId: String): PostCommentApiResponse {
        return postHttpImpl.getPostCommentList(postId)
    }
}