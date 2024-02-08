package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.post.entity.PostCommentList
import com.nuhin13.domain.feature.post.usecase.GetPostCommentList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(val commentUseCase: GetPostCommentList) :
    ViewModel() {

    private val _commentData = MutableStateFlow<PostCommentList>(PostCommentList(arrayListOf()))
    val comments: StateFlow<PostCommentList> = _commentData

    fun fetchPostCommentList(postId: String) {
        viewModelScope.launch {
            try {
                //_commentData.value = commentUseCase.getPostCommentList(postId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}