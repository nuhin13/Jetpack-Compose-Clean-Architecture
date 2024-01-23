package com.nuhin13.data.features.authentication

import com.nuhin13.domain.feature.authentication.entity.ForgetPasswordReq
import com.nuhin13.domain.feature.authentication.entity.LoginReq
import com.nuhin13.domain.feature.authentication.entity.RegistrationReq
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository

class AuthRepoImpl: AuthenticationRepository {
    override fun login(loginReq: LoginReq) {
        println("From AuthRepoImpl  $loginReq")
    }

    override fun register(registrationReq: RegistrationReq) {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(forgetPasswordReq: ForgetPasswordReq) {
        TODO("Not yet implemented")
    }
}