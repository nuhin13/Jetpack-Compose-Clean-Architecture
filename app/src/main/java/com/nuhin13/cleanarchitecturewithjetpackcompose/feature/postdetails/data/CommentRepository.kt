package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.data
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostCommentApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.di.network.RetrofitInstance

class CommentRepository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getPostComment(postId:String): PostCommentApiResponse {
        return apiService.getPostComments(postId)
    }
}