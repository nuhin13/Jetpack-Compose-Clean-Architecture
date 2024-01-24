package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.registration.vm

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.dao.UserInfoDao
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.table.UserInfo
import com.nuhin13.domain.entities.Email
import com.nuhin13.domain.entities.Password
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.feature.authentication.entity.RegistrationReq
import com.nuhin13.domain.feature.authentication.repository.AuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val  authenticationUseCase: AuthenticationUseCase,
    @ApplicationContext val appContext: Context
) : ViewModel() {

    fun addUser(phone: String, email: String, pin: String) {
        viewModelScope.launch {
            //userInfoDao.insert(UserInfo(phoneNumber = phone, pin = pin, email = email))
            val reg = authenticationUseCase.doRegistration(
                RegistrationReq(
                    email = Email(emailAddress = email),
                    phoneNumber = PhoneNumber(number = phone),
                    password = Password(password = pin)
                )
            )

            Toast.makeText(appContext, "Successfully Added $reg", Toast.LENGTH_LONG).show()

            //Log.d("RegistrationViewModel", userInfoDao.fetchAll().toString())
        }
    }
}