package com.nuhin13.data.features.post.dtos

import com.nuhin13.data.features.user.dtos.OwnerApiModel

data class PostApiResponse(
    val `data`: ArrayList<PostApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)

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