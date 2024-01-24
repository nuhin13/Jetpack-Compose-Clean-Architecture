package com.nuhin13.data.features.authentication.datasource

import com.nuhin13.data.features.authentication.db.dao.UserInfoDao
import com.nuhin13.data.features.authentication.db.table.UserInfoTable
import com.nuhin13.domain.feature.authentication.entity.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthenticationLocalSourceImpl @Inject constructor(
    private val dao: UserInfoDao
) : AuthenticationDataSource {
    override suspend fun storeRegistrationData(registrationReq: RegistrationReq): Boolean {
        dao.insert(
            UserInfoTable(
                phoneNumber = registrationReq.phoneNumber?.number!!,
                email = registrationReq.email?.emailAddress,
                pin = registrationReq.password?.password!!
            )
        )

        return true
    }

    override suspend fun checkLoginInfo(loginReq: LoginReq): Flow<UserInfo> {
        TODO("Not yet implemented")
    }

}