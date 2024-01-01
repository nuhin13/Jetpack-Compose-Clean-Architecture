package com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post

import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.OwnerApiModel

data class PostApiModel(
    val id: String,
    val image: String?,
    val likes: Int = 0,
    val owner: OwnerApiModel,
    val publishDate: String?,
    val tags: List<String>,
    val text: String?,
    val updatedDate: String?
)