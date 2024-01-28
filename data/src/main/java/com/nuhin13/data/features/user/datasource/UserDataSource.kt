package com.nuhin13.data.features.user.datasource
import com.nuhin13.data.features.user.dtos.UserApiResponse

interface UserDataSource {
    suspend fun getUserList(): UserApiResponse
}