package com.nuhin13.data.features.authentication.datasource

import com.google.gson.Gson
import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import com.nuhin13.data.features.authentication.db.table.UserInfoTable
import com.nuhin13.data.localstorage.datastore.PrefConstant
import com.nuhin13.data.localstorage.datastore.PreferencesDataStore
import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.entities.Token
import com.nuhin13.domain.feature.authentication.entity.*
import javax.inject.Inject

class AuthenticationLocalSourceImpl @Inject constructor(
    private val dao: UserInfoDao,
    private val sharedPreferencesDataStore: PreferencesDataStore
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

    override suspend fun loginInfo(loginReq: LoginReq): UserInfo {
        dao.fetchByPhone(loginReq.phoneNumber?.number!!)?.let {
            return generateUserInfo(loginReq, it)
        }.run {
            return (UserInfo(userLogin = LoginState.USER_NOT_FOUND))
        }
    }

    override suspend fun checkLoginSession(): Boolean {
        return sharedPreferencesDataStore.getJson(PrefConstant.USER_INFO).isNotEmpty()
    }

    private suspend fun generateUserInfo(loginReq: LoginReq, infoTable: UserInfoTable): UserInfo {
        var loginType = LoginState.LOGIN_SUCCESS

        if (infoTable.pin != loginReq.password?.password!!) {
            loginType = LoginState.PASSWORD_NOT_MATCHED
        }

        val info = UserInfo(
            userLogin = loginType,
            phone = PhoneNumber(infoTable.phoneNumber),
            email = Email(infoTable.email),
            token = Token(appId = "657eef24ed571a529367f1be")
        )

        sharedPreferencesDataStore.saveJson(PrefConstant.USER_INFO, Gson().toJson(info))
        return info
    }
}