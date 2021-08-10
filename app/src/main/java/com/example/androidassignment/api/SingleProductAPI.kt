package com.example.androidassignment.api

import com.example.androidassignment.response.ProductResponse

interface SingleProductAPI {
    //Single product show
    @GET("/product/singleshow/{id}")
    suspend fun showSingleProduct(
        @Path("id")id:String
    ): Response<ProductResponse>
}