package com.example.androidassignment.dao

import com.example.androidassignment.entity.User

@DAO
interface UserDAO {
    @Insert
    suspend fun registerUser(user: User)

    @Query("select * from User where user_email=(:email) and user_password=(:password)")
    suspend fun checkUser(email: String, password: String): User
}
