package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.OwnerApiModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.data.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _postApi = MutableStateFlow<ArrayList<PostApiModel>?>(null)
    val postResponse: StateFlow<ArrayList<PostApiModel>?> = _postApi

    fun fetchPostList() {
        viewModelScope.launch {
            try {
                val cards = repository.getPostList()
                _postApi.value = cards.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}