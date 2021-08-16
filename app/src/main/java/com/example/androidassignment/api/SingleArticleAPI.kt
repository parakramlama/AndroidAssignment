package com.example.androidassignment.api

import com.example.androidassignment.response.ArticleResponse

interface SingleArticleAPI {
    //Single article show
    @GET("/article/singleshow/{id}")
    suspend fun showSingleArticle(
        @Path("id")id:String
    ): Response<ArticleResponse>
}