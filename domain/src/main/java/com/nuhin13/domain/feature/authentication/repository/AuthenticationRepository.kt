package com.nuhin13.domain.feature.authentication.repository

import com.nuhin13.domain.feature.authentication.entity.*

interface AuthenticationRepository {
    suspend fun login(loginReq: LoginReq) : UserInfo
    suspend fun register(registrationReq: RegistrationReq) : Boolean
    suspend fun forgotPassword(forgetPasswordReq: ForgetPasswordReq)
}