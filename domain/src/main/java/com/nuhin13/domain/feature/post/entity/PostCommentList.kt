package com.nuhin13.domain.feature.post.entity

data class PostCommentList(
    var comments: ArrayList<Comment> = arrayListOf(),
    val total: String,
)

data class Comment(
    val message: String,
    val publishDate: String,
    val owner: Owner,
)
