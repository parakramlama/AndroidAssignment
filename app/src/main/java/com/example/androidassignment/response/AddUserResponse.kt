package com.example.androidassignment.response

import com.example.androidassignment.entity.User

data class AddUserResponse(
    val success: Boolean?=null,
    val data : User?= null
)
