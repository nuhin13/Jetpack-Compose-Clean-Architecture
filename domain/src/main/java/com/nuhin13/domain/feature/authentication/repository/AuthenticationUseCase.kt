package com.nuhin13.domain.feature.authentication.repository

import com.nuhin13.domain.feature.authentication.entity.*

interface AuthenticationUseCase {
    suspend fun doLogin(loginReq: LoginReq){}
    suspend fun doRegistration(registrationReq: RegistrationReq): Boolean {
        return false
    }
    fun doForgetPassword(forgetPasswordReq: ForgetPasswordReq){}
}