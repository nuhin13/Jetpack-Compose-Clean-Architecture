package com.nuhin13.domain.feature.authentication.entity

import com.nuhin13.domain.entities.*

data class LoginReq(var phoneNumber: PhoneNumber?, var password: Password?) {

}