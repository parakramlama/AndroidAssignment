package com.example.androidassignment.db

import android.content.Context
import com.example.androidassignment.entity.Article

@Database(
    entities = [(Article::class)],
    version = 1,
    exportSchema = false
)
abstract class ArticleDB : RoomDatabase() {
    abstract fun getArticleDAO() : ArticleDAO

    companion object{
        @Volatile
        private var instance : ArticleDB? = null

        fun getInstance(context : Context) : ArticleDB{
            if(instance == null){
                synchronized(ArticleDB::class){
                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context : Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDB::class.java,
                "ArticleDatabase"
            ).build()

    }
}