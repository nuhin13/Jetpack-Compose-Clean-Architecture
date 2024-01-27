package com.nuhin13.data.features.user.dtos

data class UserApiResponse(
    val `data`: ArrayList<OwnerApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)

data class OwnerApiModel(
    val firstName: String?,
    val id: String,
    val lastName: String?,
    val picture: String?,
    val title: String?
)