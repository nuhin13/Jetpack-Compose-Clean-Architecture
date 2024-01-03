package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.data
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.api.ApiService
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostCommentApiResponse
import javax.inject.Inject

class CommentRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPostComment(postId:String): PostCommentApiResponse {
        return apiService.getPostComments(postId)
    }
}