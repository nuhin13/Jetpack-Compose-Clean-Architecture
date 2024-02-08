package com.nuhin13.data.features.post.datasource

import com.google.gson.Gson
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.data.localstorage.datastore.PrefConstant
import com.nuhin13.data.localstorage.datastore.PreferencesDataStore
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostLocalSourceImpl @Inject constructor(
    private val postHttpImpl: PostHttpImpl,
    private val pref: PreferencesDataStore
) :
    PostDataSource {
    override suspend fun getPostList(): Flow<DataResult<PostApiResponse>?> {
        if (pref.getJson(PrefConstant.POST_LIST).isNotEmpty()) {
            return flow {
                emit(DataResult.Loading(null, true))

                emit(DataResult.Success(
                    Gson().fromJson(
                        pref.getJson(PrefConstant.POST_LIST),
                        PostApiResponse::class.java
                    )
                ))
            }
        }

        val postApiResponse = postHttpImpl.getPostList().onEach {
            if (it is DataResult.Success) {
                pref.saveJson(PrefConstant.POST_LIST, Gson().toJson(it.data))
            }
        }

        return postApiResponse
    }

    override suspend fun getPostCommentList(postId: String): Flow<DataResult<PostCommentApiResponse>?> {
        return postHttpImpl.getPostCommentList(postId)
    }
}