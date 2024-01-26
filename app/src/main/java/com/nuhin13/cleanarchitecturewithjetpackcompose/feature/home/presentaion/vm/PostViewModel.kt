package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.presentaion.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostApiModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _postApi = MutableStateFlow<ArrayList<PostApiModel>?>(null)
    val postResponse: StateFlow<ArrayList<PostApiModel>?> = _postApi

    fun fetchPostList() {
        viewModelScope.launch {
            try {
                val cards = postRepository.getPostList()
                _postApi.value = cards.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}