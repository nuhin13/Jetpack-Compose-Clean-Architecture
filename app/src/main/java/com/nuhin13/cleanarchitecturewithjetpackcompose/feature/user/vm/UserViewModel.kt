package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.user.entity.OwnerList
import com.nuhin13.domain.feature.user.usecase.GetUserList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var userListUseCase: GetUserList

    private val _userList = MutableStateFlow<OwnerList>(OwnerList(arrayListOf()))
    val userList: StateFlow<OwnerList> = _userList

    fun fetchUserList() {
        viewModelScope.launch {
            try {
                val user = userListUseCase.getUserList()
                _userList.value = user
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}