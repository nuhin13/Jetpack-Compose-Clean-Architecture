package com.nuhin13.data.features.post

import com.google.gson.Gson
import com.nuhin13.data.features.post.datasource.PostDataSource
import com.nuhin13.data.localstorage.datastore.PrefConstant
import com.nuhin13.domain.feature.post.entity.Owner
import com.nuhin13.domain.feature.post.entity.PostComment
import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.entity.PostItem
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.repository.PostRepository
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val postDataSource: PostDataSource) :
    PostRepository {
    override suspend fun getPostList(): Flow<DataResult<PostItemList>> {
        return postDataSource.getPostList().map { postApiResponse ->
            when (postApiResponse) {
                is DataResult.Success -> {
                    val postList = ArrayList<PostItem>()
                    for (post in postApiResponse.data!!.data) {
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

                    DataResult.Success(PostItemList(postList))
                }

                is DataResult.Error -> {
                    DataResult.Error("")
                }

                is DataResult.Loading -> {
                    DataResult.Loading(null, true)
                }

                else -> {
                    DataResult.Error("")
                }
            }
        }
    }

    override suspend fun getPostCommentList(postId: String): Flow<DataResult<PostCommentList>> {
        return  flow {
            emit(DataResult.Loading(null, true))
        }

//        val commentList = PostCommentList(comments = arrayListOf())
//        val commentResponse = postDataSource.getPostCommentList(postId)
//
//        if (commentResponse.data.size > 0) {
//            val postComment = ArrayList<PostComment>()
//            for (comment in commentResponse.data) {
//                postComment.add(
//                    PostComment(
//                        message = comment.message ?: "",
//                        publishDate = comment.publishDate ?: "",
//                        owner = Owner(
//                            profilePic = comment.owner.picture,
//                            fullName = comment.owner.title + ". " + comment.owner.firstName + " " + comment.owner.lastName
//                        )
//                    )
//                )
//            }
//            commentList.comments = postComment
//            commentList.total = commentResponse.data.size
//        }
//        return commentList
    }
}