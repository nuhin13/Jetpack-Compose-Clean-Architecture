package com.nuhin13.data.features.post.datasource

import com.google.gson.Gson
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.data.localstorage.datastore.PrefConstant
import com.nuhin13.data.localstorage.datastore.PreferencesDataStore
import com.nuhin13.data.localstorage.datastore.PreferencesDataStoreImpl
import javax.inject.Inject

class PostLocalSourceImpl @Inject constructor(
    private val postHttpImpl: PostHttpImpl,
    private val pref: PreferencesDataStore
) :
    PostDataSource {
    override suspend fun getPostList(): PostApiResponse {
        if (pref.getJson(PrefConstant.POST_LIST).isNotEmpty()) {
            return Gson().fromJson(
                pref.getJson(PrefConstant.POST_LIST),
                PostApiResponse::class.java
            )
        }

        val postApiResponse = postHttpImpl.getPostList()
        pref.saveJson(PrefConstant.POST_LIST, Gson().toJson(postApiResponse))

        return postApiResponse
    }

    override suspend fun getPostCommentList(postId: String): PostCommentApiResponse {
        return postHttpImpl.getPostCommentList(postId)
    }
}