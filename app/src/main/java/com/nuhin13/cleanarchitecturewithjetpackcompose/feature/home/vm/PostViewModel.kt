package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhin13.domain.feature.post.entity.PostItemList
import com.nuhin13.domain.feature.post.usecase.GetPostList
import com.nuhin13.domain.util.DataStatus
import com.nuhin13.domain.util.DataStatus.LOADING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.sql.DataSource

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostUseCase: GetPostList) : ViewModel() {

    private val _postApi = MutableStateFlow<PostItemList>(PostItemList(arrayListOf()))
    val postResponse: StateFlow<PostItemList> = _postApi

    fun fetchPostList() {
        viewModelScope.launch {
            try {
                getPostUseCase.getPostList().collect {
//                    if(it as LOADING){
//                        println("Loading")
//                    }

                    println(it)
                }
                //_postApi.value = postData
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}