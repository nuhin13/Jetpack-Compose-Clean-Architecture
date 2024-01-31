package com.nuhin13.data.features.authentication.datasource

import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.feature.authentication.entity.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface AuthenticationDataSource {
    suspend fun storeRegistrationData(registrationReq: RegistrationReq): Boolean
    suspend fun loginInfo(loginReq: LoginReq):UserInfo
    suspend fun checkLoginSession():Boolean
    suspend fun forgetPassword(email: Email): Flow<String> = emptyFlow()
}