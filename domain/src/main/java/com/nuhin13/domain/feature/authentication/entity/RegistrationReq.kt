package com.nuhin13.domain.feature.authentication.entity

import com.nuhin13.domain.entities.*

class RegistrationReq(
    val email: Email?,
    val password: Password?,
    val phoneNumber: PhoneNumber?,
    val name: PersonName? = null,
    val address: Address? = null
) {

}