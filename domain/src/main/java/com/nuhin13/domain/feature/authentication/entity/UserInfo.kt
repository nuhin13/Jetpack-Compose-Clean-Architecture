package com.nuhin13.domain.feature.authentication.entity

import android.location.Address
import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.entities.Token
import com.nuhin13.domain.entities.PersonName

class UserInfo {
    val name: PersonName? = null
    val email: Email? = null
    val token: Token? = null
    val profileImage: String? = null
    val address: Address? = null
    val phone: PhoneNumber? = null
}