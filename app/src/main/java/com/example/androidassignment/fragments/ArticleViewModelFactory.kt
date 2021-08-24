package com.example.androidassignment.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidassignment.repository.ArticleRepository

class ArticleViewModelFactory (val repository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass:Class<T>):T{
        return ArticleViewModel(repository) as T
    }
}