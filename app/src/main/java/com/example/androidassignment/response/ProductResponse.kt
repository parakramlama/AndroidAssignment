package com.example.androidassignment.response

import com.example.androidassignment.entity.Product

data class ProductResponse(
    val success : Boolean? = null,
    val data: MutableList<Product>? = null
)

