package com.nuhin13.domain.feature.authentication.usecase

import com.nuhin13.domain.feature.authentication.entity.*
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationRepository: AuthenticationRepository) {
    suspend fun doLogin(loginReq: LoginReq): String {
        println("From LoginUseCase $loginReq")

        val info = authenticationRepository.login(loginReq)

        return when (info.userLogin) {
            LoginState.LOGIN_SUCCESS -> {
                "Success"
            }

            LoginState.PASSWORD_NOT_MATCHED -> {
                "Password not matched"
            }

            LoginState.USER_NOT_FOUND -> {
                "User not found"
            }

            else -> {
                "Login failed"
            }
        }
    }
}