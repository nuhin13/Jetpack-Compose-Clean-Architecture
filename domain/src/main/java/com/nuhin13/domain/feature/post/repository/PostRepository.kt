package com.nuhin13.domain.feature.post.repository

import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.entity.PostItemList

interface PostRepository {
    suspend fun getPostList() : PostItemList
    suspend fun getPostCommentList(postId:String) : PostCommentList
}