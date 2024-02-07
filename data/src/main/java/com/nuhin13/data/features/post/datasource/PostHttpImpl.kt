package com.nuhin13.data.features.post.datasource

import com.nuhin13.data.api.ApiService
import com.nuhin13.data.api.toResultFlow
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostHttpImpl @Inject constructor(private val apiService: ApiService) :
    PostDataSource {
    override suspend fun getPostList(): PostApiResponse {

        val flow = toResultFlow { apiService.getPostList()  }
        flow.collect{ result ->
            println(result)
            //mLiveDataProduct?.value = result
        }

        return apiService.getPostList().body()!!
    }

    override suspend fun getPostCommentList(postId:String): PostCommentApiResponse {
        return apiService.getPostComments(postId)
    }
}