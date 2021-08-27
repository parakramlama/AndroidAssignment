package com.parakram.wearables.api

import com.parakram.wearables.response.LoginResponse

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

}