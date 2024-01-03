package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.registration.domain

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.dao.UserInfoDao
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.table.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userInfoDao: UserInfoDao,
    @ApplicationContext val appContext: Context
) : ViewModel() {

    fun addUser(phone: String, email: String, pin: String) {
        viewModelScope.launch {
            userInfoDao.insert(UserInfo(phoneNumber = phone, pin = pin, email = email))
            Toast.makeText(appContext, "Successfully Added", Toast.LENGTH_LONG).show()

            Log.d("RegistrationViewModel", userInfoDao.fetchAll().toString())
        }
    }
}