package com.nuhin13.domain.feature.post.entity

import com.nuhin13.domain.feature.user.entity.OwnerApiModel

data class PostCommentApiModel(
    val id: String,
    val message: String?,
    val owner: OwnerApiModel,
    val post: String,
    val publishDate: String?
)