package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostCommentApiModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.data.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: CommentRepository

    private val _commentApi = MutableStateFlow<ArrayList<PostCommentApiModel>?>(null)
    val commentResponse: StateFlow<ArrayList<PostCommentApiModel>?> = _commentApi

    fun fetchPostCommentList(postId: String) {
        viewModelScope.launch {
            try {
                val cards = repository.getPostComment(postId)
                _commentApi.value = cards.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}