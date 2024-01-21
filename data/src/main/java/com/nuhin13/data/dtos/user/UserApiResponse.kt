package com.nuhin13.data.dtos.user

data class UserApiResponse(
    val `data`: ArrayList<OwnerApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)