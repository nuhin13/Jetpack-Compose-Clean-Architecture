package com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.post

import android.os.Parcelable
import com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user.OwnerApiModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostApiModel(
    val id: String,
    val image: String?,
    val likes: Int = 0,
    val owner: OwnerApiModel,
    val publishDate: String?,
    val tags: ArrayList<String>,
    val text: String?,
    val updatedDate: String?
) : Parcelable