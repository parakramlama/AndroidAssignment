package com.example.androidassignment.repository

import com.example.androidassignment.api.MyApiRequest
import com.example.androidassignment.api.ServiceBuilder
import com.example.androidassignment.api.SingleArticleAPI
import com.example.androidassignment.response.ArticleResponse

class SingleArticleResponse : MyApiRequest() {
    private val singleArticleAPI = ServiceBuilder.buildService(SingleArticleAPI::class.java)

    //Display Single Article
    suspend fun getSingleArticle(id:String): ArticleResponse {
        return apiRequest {
            singleArticleAPI.showSingleArticle(id)
        }
    }
}