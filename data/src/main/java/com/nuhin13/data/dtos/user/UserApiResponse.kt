package com.nuhin13.data.dtos.user

import com.nuhin13.domain.feature.user.entity.OwnerApiModel

data class UserApiResponse(
    val `data`: ArrayList<OwnerApiModel>,
    val limit: Int? = 0,
    val page: Int? = 0,
    val total: Int? = 0,
)