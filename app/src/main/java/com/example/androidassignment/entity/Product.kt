package com.example.androidassignment.entity

@Entity
data class Product(
    @PrimaryKey()
    val _id : String,
    var product_name : String? =null,
    var product_price : String? =null,
    var product_desc : String? = null,
    var product_img : String? =null,
)

