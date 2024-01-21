package com.nuhin13.data.dtos.post

import com.nuhin13.data.dtos.user.OwnerApiModel

data class PostApiModel(
    val id: String,
    val image: String?,
    val likes: Int = 0,
    val owner: OwnerApiModel,
    val publishDate: String?,
    val tags: ArrayList<String>,
    val text: String?,
    val updatedDate: String?
)