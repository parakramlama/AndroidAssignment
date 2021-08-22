package com.example.androidassignment.db

import android.content.Context
import com.example.androidassignment.dao.UserDAO
import com.example.androidassignment.entity.User

@Database(
    entities = [(User::class)],
    version = 1,
    exportSchema = false
)
abstract class UserDB :RoomDatabase() {
    abstract fun getUserDAO() : UserDAO

    companion object{
        @Volatile
        private var instance : UserDB? = null

        fun getInstance(context : Context) : UserDB{
            if(instance == null){
                synchronized(UserDB::class){
                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "UserDatabase"
            ).build()

    }
}