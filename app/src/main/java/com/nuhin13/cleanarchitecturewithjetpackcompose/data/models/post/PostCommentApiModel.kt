package com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.OwnerApiModel

data class PostCommentApiModel(
    val id: String,
    val message: String?,
    val owner: OwnerApiModel,
    val post: String,
    val publishDate: String?
)