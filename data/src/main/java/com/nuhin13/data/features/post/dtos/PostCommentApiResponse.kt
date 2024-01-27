package com.nuhin13.data.features.post.dtos

import com.nuhin13.data.features.user.dtos.OwnerApiModel


data class PostCommentApiResponse(
    val `data`: ArrayList<PostCommentApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)

data class PostCommentApiModel(
    val id: String,
    val message: String?,
    val owner: OwnerApiModel,
    val post: String,
    val publishDate: String?
)