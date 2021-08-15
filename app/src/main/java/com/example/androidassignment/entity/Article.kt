package com.example.androidassignment.entity

@Entity
data class Article(
    @PrimaryKey()
    val _id : String,
    var article_title : String? =null,
    var article_body : String? =null,
)
