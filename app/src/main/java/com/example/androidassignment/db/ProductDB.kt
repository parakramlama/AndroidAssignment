package com.example.androidassignment.db

import android.content.Context
import com.example.androidassignment.dao.ProductDAO
import com.example.androidassignment.entity.Product

@Database(
    entities = [(Product::class)],
    version = 1,
    exportSchema = false
)

abstract class ProductDB : RoomDatabase() {
    abstract fun getProductDAO() : ProductDAO

    companion object{
        @Volatile
        private var instance : ProductDB? = null

        fun getInstance(context : Context) : ProductDB{
            if(instance == null){
                synchronized(ProductDB::class){
                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProductDB::class.java,
                "ProductDatabase"
            ).build()

    }

}