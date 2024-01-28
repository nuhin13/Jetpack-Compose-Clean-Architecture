package com.nuhin13.data.features.user.datasource

import com.nuhin13.data.features.user.dtos.UserApiResponse
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor (private val userHttpImpl: UserHttpDataSourceImpl) : UserDataSource {
    override suspend fun getUserList(): UserApiResponse {
       return userHttpImpl.getUserList()
    }
}