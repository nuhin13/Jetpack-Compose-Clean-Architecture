package com.nuhin13.domain.feature.authentication.usecase

import com.nuhin13.domain.feature.authentication.entity.RegistrationReq
import com.nuhin13.domain.feature.authentication.repository.AuthenticationRepository
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend fun doRegistration(registrationReq: RegistrationReq): Boolean {
        println("From RegistrationUseCase $registrationReq")

        return authenticationRepository.register(registrationReq)
    }
}