package com.nuhin13.domain.feature.post.entity

import java.io.Serializable

data class PostItemList(var postList: List<PostItem> = arrayListOf())

data class PostItem(
    val id: String,
    val description: String? = null,
    val imageLink: String? = null,
    val publishDate: String = "",
    val likeCount: Int = 0,
    val owner: Owner? = null,
) : Serializable

data class Owner(val profilePic: String? = null, val fullName: String = "") : Serializable
