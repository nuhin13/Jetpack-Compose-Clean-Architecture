package com.nuhin13.data.features.authentication

import com.nuhin13.data.features.authentication.datasource.AuthenticationDataSource
import com.nuhin13.domain.feature.authentication.entity.ForgetPasswordReq
import com.nuhin13.domain.feature.authentication.entity.LoginReq
import com.nuhin13.domain.feature.authentication.entity.RegistrationReq
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val authenticationDataSource: AuthenticationDataSource) :
    AuthenticationRepository {
    override suspend fun login(loginReq: LoginReq) {
        println("From AuthRepoImpl  $loginReq")
    }

    override suspend fun register(registrationReq: RegistrationReq): Boolean {
        println("From AuthRepoImpl  $registrationReq")

        return authenticationDataSource.storeRegistrationData(registrationReq)
    }

    override suspend fun forgotPassword(forgetPasswordReq: ForgetPasswordReq) {
        TODO("Not yet implemented")
    }
}