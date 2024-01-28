package com.nuhin13.domain.feature.user.usecase

import com.nuhin13.domain.feature.user.entity.OwnerList
import com.nuhin13.domain.feature.user.repository.UserRepository
import javax.inject.Inject

class GetUserList @Inject constructor(private val userRepo: UserRepository) {
    suspend fun getUserList(): OwnerList {
        return userRepo.getUserList()
    }
}