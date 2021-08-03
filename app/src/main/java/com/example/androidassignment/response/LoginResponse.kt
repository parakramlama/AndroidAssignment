package com.example.androidassignment.response

import com.example.androidassignment.entity.User

data class LoginResponse(
    val success :Boolean? = null,
    val token : String? = null,
    val data: User? = null
)
