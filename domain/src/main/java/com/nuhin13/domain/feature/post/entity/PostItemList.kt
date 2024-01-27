package com.nuhin13.domain.feature.post.entity


data class PostItemList(var postList: List<PostItem>  = arrayListOf())

data class PostItem(
    val description: String,
    val imageLink: String?,
    val likeCount: Int = 0,
    val owner: Owner
)

data class Owner(val ownerImage: String, val ownerName: String)
