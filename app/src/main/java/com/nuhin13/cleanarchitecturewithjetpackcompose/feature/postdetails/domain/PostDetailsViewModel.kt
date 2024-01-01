package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.domain
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post.PostCommentApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.UserApiResponse
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.postdetails.data.CommentRepository
import kotlinx.coroutines.launch

class PostDetailsViewModel : ViewModel() {
    private val repository = CommentRepository()

    private val _commentApi = MutableLiveData<PostCommentApiResponse>()
    val commentResponse: LiveData<PostCommentApiResponse> = _commentApi

    fun fetchPostCommentList() {
        viewModelScope.launch {
            try {
                val cards = repository.getPostComment("60d21bf867d0d8992e610e98")
                _commentApi.postValue(cards)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}