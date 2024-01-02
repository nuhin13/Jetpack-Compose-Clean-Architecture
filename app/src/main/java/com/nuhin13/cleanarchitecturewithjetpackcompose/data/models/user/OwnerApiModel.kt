package com.nuhin13.cleanarchitecturewithjetpackcompose.data.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OwnerApiModel(
    val firstName: String?,
    val id: String,
    val lastName: String?,
    val picture: String?,
    val title: String?
):Parcelable