package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.usecase.GetPostList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostUseCase: GetPostList) : ViewModel() {

    private val _postApi = MutableStateFlow<PostItemList>(PostItemList(arrayListOf()))
    val postResponse: StateFlow<PostItemList> = _postApi

    fun fetchPostList() {
        viewModelScope.launch {
            try {
                val postData = getPostUseCase.getPostList()
                _postApi.value = postData
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}