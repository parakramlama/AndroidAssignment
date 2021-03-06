package com.example.androidassignment.api

import com.example.androidassignment.entity.User
import com.example.androidassignment.response.LoginResponse

interface UserAPI {
    //Register user
    @POST("user/insert")
    suspend fun registerUser(
        @Body user: User
    ): Response<LoginResponse>


    //Login
    @FormUrlEncoded
    @POST("user/login")
    suspend fun checkUser(
        @Field("user_email") user_email:String,
        @Field("user_password") user_password:String
    ): Response<LoginResponse>


    //retrieve User
    @GET("user/show/{id}")
    suspend fun retrieveUser(
        @Header("Authorization") token:String,
        @Field("token") userToken:String
    ):Response<LoginResponse>

    @PUT("user/update/{id}")
    suspend fun updateUser(
        @Header("Authorization")token: String
    ):Response<LoginResponse>
}
}