package com.nuhin13.domain.feature.user.usecase

import com.nuhin13.domain.feature.user.repository.UserRepository
import javax.inject.Inject

class GetUserDetails @Inject constructor(private val userRepo: UserRepository) {
    fun getUserDetails() {
        //userRepo.getUserDetails()
    }
}