package com.nuhin13.data.features.post

import com.nuhin13.data.features.post.datasource.PostDataSource
import com.nuhin13.domain.feature.post.entity.Owner
import com.nuhin13.domain.feature.post.entity.PostComment
import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.entity.PostItem
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.repository.PostRepository
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val postDataSource: PostDataSource) :
    PostRepository {
    override suspend fun getPostList(): PostItemList {

        val postItemList = PostItemList(arrayListOf())

        val postResponse = postDataSource.getPostList()

        if (postResponse.data.size > 0) {
            val postList = ArrayList<PostItem>()
            for (post in postResponse.data) {
                val postItem = PostItem(
                    id = post.id,
                    description = post.text,
                    imageLink = post.image,
                    likeCount = post.likes,
                    publishDate = post.publishDate ?: "",
                    owner = Owner(
                        profilePic = post.owner.picture,
                        fullName = post.owner.title + ". " + post.owner.firstName + " " + post.owner.lastName
                    )
                )
                postList.add(postItem)
            }
            postItemList.postList = postList
        }
        return postItemList
    }

    override suspend fun getPostCommentList(postId: String): PostCommentList {
        val commentList = PostCommentList(comments = arrayListOf())
        val commentResponse = postDataSource.getPostCommentList(postId)

        if (commentResponse.data.size > 0) {
            val postComment = ArrayList<PostComment>()
            for (comment in commentResponse.data) {
                postComment.add(
                    PostComment(
                        message = comment.message ?: "",
                        publishDate = comment.publishDate ?: "",
                        owner = Owner(
                            profilePic = comment.owner.picture,
                            fullName = comment.owner.title + ". " + comment.owner.firstName + " " + comment.owner.lastName
                        )
                    )
                )
            }
            commentList.comments = postComment
            commentList.total = commentResponse.data.size
        }
        return commentList
    }
}