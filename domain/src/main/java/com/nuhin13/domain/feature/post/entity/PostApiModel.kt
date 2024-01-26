package com.nuhin13.domain.feature.post.entity

import com.nuhin13.domain.feature.user.entity.OwnerApiModel

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