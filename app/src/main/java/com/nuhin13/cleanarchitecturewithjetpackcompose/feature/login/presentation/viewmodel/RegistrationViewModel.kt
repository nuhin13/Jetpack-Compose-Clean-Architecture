package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.UserInfoDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val userInfoDao: UserInfoDao) : ViewModel(){

}