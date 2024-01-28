package com.nuhin13.data.features.user.datasource
import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.user.dtos.UserApiResponse
import javax.inject.Inject

class UserHttpDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    UserDataSource {
    override suspend fun getUserList(): UserApiResponse {
        return apiService.getUsersList()
    }
}