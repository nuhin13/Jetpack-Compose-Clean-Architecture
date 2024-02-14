package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.usecase.GetPostList
import com.nuhin13.domain.util.DataStatus
import com.nuhin13.domain.util.DataStatus.LOADING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostUseCase: GetPostList) : ViewModel() {
    data class PostListUiState(
        val status: DataStatus = LOADING,
        val postList: PostItemList = PostItemList(arrayListOf())
    )

    private val _uiState: MutableStateFlow<PostListUiState> = MutableStateFlow(PostListUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchPostList() {
        viewModelScope.launch {
            try {
                getPostUseCase.getPostList().collect {
                    _uiState.value = PostListUiState(
                        it.status,
                        it.data ?: PostItemList(arrayListOf())
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}