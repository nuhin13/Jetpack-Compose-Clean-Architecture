package com.nuhin13.domain.feature.authentication.entity

import android.location.Address
import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.entities.Token
import com.nuhin13.domain.entities.PersonName

class UserInfo(
    var name: PersonName? = null,
    var email: Email? = null,
    var token: Token? = null,
    var profileImage: String? = null,
    var address: Address? = null,
    var phone: PhoneNumber? = null,
    var userLogin: LoginState = LoginState.LOGIN_FAILED,
)

enum class LoginState {
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    USER_NOT_FOUND,
    PASSWORD_NOT_MATCHED,
}