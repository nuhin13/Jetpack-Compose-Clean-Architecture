package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.UserApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.data.PostRepository
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.user.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _userApi = MutableLiveData<UserApiResponse>()
    val userResponse: LiveData<UserApiResponse> = _userApi

    fun fetchUserList() {
        viewModelScope.launch {
            try {
                val cards = repository.getUserList()
                _userApi.postValue(cards)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}