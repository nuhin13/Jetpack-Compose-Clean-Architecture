package com.nuhin13.data.dtos.post

import com.nuhin13.data.dtos.user.OwnerApiModel

data class PostCommentApiModel(
    val id: String,
    val message: String?,
    val owner: OwnerApiModel,
    val post: String,
    val publishDate: String?
)