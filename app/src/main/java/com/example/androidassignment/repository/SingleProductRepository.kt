package com.example.androidassignment.repository

import com.example.androidassignment.api.MyApiRequest
import com.example.androidassignment.api.ServiceBuilder
import com.example.androidassignment.api.SingleProductAPI
import com.example.androidassignment.response.ProductResponse

class SingleProductRepository : MyApiRequest() {
    private val singleProductAPI = ServiceBuilder.buildService(SingleProductAPI::class.java)

    //Display Single Product
    suspend fun getSingleProduct(id:String): ProductResponse {
        return apiRequest {
            singleProductAPI.showSingleProduct(id)
        }
    }
}