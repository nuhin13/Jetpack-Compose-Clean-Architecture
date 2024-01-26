package com.nuhin13.data.dtos.post

import com.nuhin13.domain.feature.post.entity.PostApiModel

data class PostApiResponse(
    val `data`: ArrayList<PostApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)