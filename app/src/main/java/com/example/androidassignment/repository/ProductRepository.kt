package com.example.androidassignment.repository

import android.util.Log
import com.example.androidassignment.api.MyApiRequest
import com.example.androidassignment.api.ProductAPI
import com.example.androidassignment.api.ServiceBuilder
import com.example.androidassignment.dao.ProductDAO
import com.example.androidassignment.entity.Product

class ProductRepository (private val productDao: ProductDAO): MyApiRequest() {
    private val productAPI = ServiceBuilder.buildService(ProductAPI::class.java)
//    suspend fun getAllProducts(): ProductResponse {
//        return apiRequest {
//            productAPI.getAllProducts()
//        }
//    }

    suspend fun displayAllProducts() : MutableList<Product>?{
        try {
            val response = apiRequest{productAPI.getAllProducts()}
            saveInRoom(response.data!!)
            return productDao.getAllProducts()
        }
        catch(ex:Exception){
            Log.d("repo",ex.toString())
        }
        return productDao.getAllProducts()
    }

    private suspend fun saveInRoom(products: MutableList<Product>){
        for (product in products){
            productDao.insertProduct(product)
        }
    }
}
