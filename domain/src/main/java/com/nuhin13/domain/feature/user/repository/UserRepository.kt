package com.nuhin13.domain.feature.user.repository

import com.nuhin13.domain.feature.post.entity.Owner
import com.nuhin13.domain.feature.user.entity.OwnerList

interface UserRepository {
    suspend fun getUserList(): OwnerList
    suspend fun getUserDetails(): Owner
}