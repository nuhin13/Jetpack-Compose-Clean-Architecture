package com.nuhin13.domain.feature.authentication.usecase

import com.nuhin13.domain.feature.authentication.entity.LoginReq
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import com.nuhin13.domain.feature.authentication.repository.AuthenticationUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) :
    AuthenticationUseCase {
    override fun doLogin(loginReq: LoginReq) {
        println("From LoginUseCase $loginReq")
        authenticationRepository.login(loginReq)
    }
}