package com.example.androidassignment.entity

@Entity
data class Cart(
    al _id: String? = null,
    val user: String?=null,
    val product: Product?= null,
    val quantity: Int? = 0
){
    @PrimaryKey(autoGenerate = true)
    var cartId:Int=0
}

