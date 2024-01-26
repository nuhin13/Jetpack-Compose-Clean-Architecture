package com.nuhin13.data.dtos.post

import com.nuhin13.domain.feature.post.entity.PostCommentApiModel

data class PostCommentApiResponse(
    val `data`: ArrayList<PostCommentApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)