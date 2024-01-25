package com.nuhin13.data.features.authentication.datasource

import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import com.nuhin13.data.features.authentication.db.table.UserInfoTable
import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.entities.Token
import com.nuhin13.domain.feature.authentication.entity.*
import javax.inject.Inject

class AuthenticationLocalSourceImpl @Inject constructor(
    private val dao: UserInfoDao
) : AuthenticationDataSource {
    override suspend fun storeRegistrationData(registrationReq: RegistrationReq): Boolean {
        if(dao.fetchByPhone(registrationReq.phoneNumber?.number!!) != null) {
            return false
        }

        dao.insert(
            UserInfoTable(
                phoneNumber = registrationReq.phoneNumber?.number!!,
                email = registrationReq.email?.emailAddress,
                pin = registrationReq.password?.password!!
            )
        )

        return true
    }

    override suspend fun checkLoginInfo(loginReq: LoginReq): UserInfo {
        dao.fetchByPhone(loginReq.phoneNumber?.number!!)?.let {
            return generateUserInfo(loginReq, it)
        }.run {
            return (UserInfo(userLogin = LoginState.USER_NOT_FOUND))
        }
    }

    private fun generateUserInfo(loginReq: LoginReq, infoTable: UserInfoTable): UserInfo {
        var loginType = LoginState.LOGIN_SUCCESS

        if (infoTable.pin != loginReq.password?.password!!) {
            loginType = LoginState.PASSWORD_NOT_MATCHED
        }

        return UserInfo(
            userLogin = loginType,
            phone = PhoneNumber(infoTable.phoneNumber),
            email = Email(infoTable.email),
            token = Token(appId = "657eef24ed571a529367f1be")
        )
    }
}