package com.example.androidassignment.response

import com.example.androidassignment.entity.Article

data class ArticleResponse(
    val success : Boolean? = null,
    val data: MutableList<Article>? = null
)
