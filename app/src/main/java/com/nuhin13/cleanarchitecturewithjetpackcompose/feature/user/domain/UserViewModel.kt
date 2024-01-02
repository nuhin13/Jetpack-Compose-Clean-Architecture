package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.api.ApiService
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.OwnerApiModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var userRepository: UserRepository

    private val _userApi = MutableStateFlow<ArrayList<OwnerApiModel>?>(null)
    val userResponse: StateFlow<ArrayList<OwnerApiModel>?> = _userApi

    fun fetchUserList() {
        viewModelScope.launch {
            try {
                val user = userRepository.getUserList()
                _userApi.value = user.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}