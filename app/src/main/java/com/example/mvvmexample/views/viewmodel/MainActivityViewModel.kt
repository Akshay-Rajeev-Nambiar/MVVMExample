package com.example.mvvmexample.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.views.repository.MainRepository

class MainActivityViewModel: ViewModel() {
    private val repository = MainRepository()
    val random: LiveData<Int>
    init {
        this.random = repository.getRandomNumber()
    }
    fun changeValue(){
        repository.incrementNumber()
    }
}