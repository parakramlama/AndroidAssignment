package com.example.androidassignment

import com.example.androidassignment.api.ServiceBuilder
import com.example.androidassignment.entity.User
import com.example.androidassignment.repository.CartRepository
import com.example.androidassignment.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UnitTesting {
    private lateinit var userRepository: UserRepository
    private lateinit var postRepository: CartRepository
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("k999@gmail.com", "ujjwal")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun checkSignup() = runBlocking {
        val user = User(user_contactno = "987666",user_email = "ujjwal@gmail.com",user_username = "uj12",user_password = "password")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun deleteCart() = runBlocking {
        postRepository = CartRepository()
        userRepository = UserRepository()
        ServiceBuilder.token ="Bearer " + userRepository.checkUser("k999@gmail.com","ujjwal").token
        val response = postRepository.deleteCart("607b1ce69261d9202481e83b",ServiceBuilder.token!!)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

}