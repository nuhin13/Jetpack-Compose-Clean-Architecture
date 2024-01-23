package com.nuhin13.domain.feature.authentication.entity

import com.nuhin13.domain.entities.*

class RegistrationReq {
    val email: Email? = null
    val password: Password? = null
    val phoneNumber: PhoneNumber? = null
    val name: PersonName? = null
    val address: Address? = null
}