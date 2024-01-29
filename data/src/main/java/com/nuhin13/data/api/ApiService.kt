package com.nuhin13.data.api

import com.nuhin13.data.features.post.datasource.PostApiService
import com.nuhin13.data.features.post.dtos.PostApiResponse
import com.nuhin13.data.features.post.dtos.PostCommentApiResponse
import com.nuhin13.data.features.user.datasource.UserApiService
import com.nuhin13.data.features.user.dtos.UserApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService: PostApiService, UserApiService {

}