package com.parakram.wearables.repository

import com.parakram.wearables.api.MyApiRequest
import com.parakram.wearables.api.ServiceBuilder
import com.parakram.wearables.entity.User
import com.parakram.wearables.response.LoginResponse

class UserRepository : MyApiRequest() {
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    suspend fun checkUser(user_email: String, user_password: String): LoginResponse {
        return apiRequest {
            userAPI.checkUser(user_email, user_password)
        }
    }


}