package com.parakram.wearables.response

import com.parakram.wearables.entity.User

data class LoginResponse(
    val success :Boolean? = null,
    val token : String? = null,
    val data: MutableList<User>? = null
)
