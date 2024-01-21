package com.nuhin13.data.dtos.post

data class PostCommentApiResponse(
    val `data`: ArrayList<PostCommentApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)