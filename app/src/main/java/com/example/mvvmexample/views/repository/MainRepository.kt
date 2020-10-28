package com.example.mvvmexample.views.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainRepository {
    private val randomNumber= MutableLiveData<Int>()
    init {
        this.randomNumber.value = 0
    }
    fun getRandomNumber(): LiveData<Int>{
        return  randomNumber
    }
    fun incrementNumber(){
        randomNumber.value = randomNumber.value?.plus(1)
    }
}