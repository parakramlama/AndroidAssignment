package com.example.androidassignment.response

import com.example.androidassignment.entity.Cart

data class CartResponse(
    val success: Boolean? = null,
    val data: MutableList<Cart>? = null
)
