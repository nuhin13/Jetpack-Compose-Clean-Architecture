package com.nuhin13.domain.feature.authentication.repository

import com.nuhin13.domain.feature.authentication.entity.*

interface AuthenticationUseCase {
    fun doLogin(loginReq: LoginReq){}
    fun doRegistration(registrationReq: RegistrationReq){}
    fun doForgetPassword(forgetPasswordReq: ForgetPasswordReq){}
}