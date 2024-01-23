package com.nuhin13.domain.feature.authentication.repository

import com.nuhin13.domain.feature.authentication.entity.*

interface AuthenticationRepository {
    fun login(loginReq: LoginReq)
    fun register(registrationReq: RegistrationReq)
    fun forgotPassword(forgetPasswordReq: ForgetPasswordReq)
}