package com.example.androidassignment.repository

import com.example.androidassignment.api.MyApiRequest
import com.example.androidassignment.api.ServiceBuilder
import com.example.androidassignment.api.UserAPI
import com.example.androidassignment.entity.User
import com.example.androidassignment.response.LoginResponse

class UserRepository : MyApiRequest(){
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    suspend fun checkUser(user_email: String, user_password: String):LoginResponse{
        return apiRequest {
            userAPI.checkUser(user_email, user_password)
        }
    }

    //Retrieve User
    suspend fun userDetails(token:String,userToken:String): LoginResponse {
        return apiRequest {
            userAPI.retrieveUser(ServiceBuilder.token!!,userToken)
        }
    }

}