package com.nuhin13.domain.feature.post.entity

data class PostCommentList(
    var comments: ArrayList<PostComment> = arrayListOf(),
    var total: Int = 0,
)

data class PostComment(
    val message: String,
    val publishDate: String,
    val owner: Owner,
)
