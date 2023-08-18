package com.example.myapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

open class BaseViewModel:ViewModel() {
    val sharedFlow= MutableSharedFlow<String>()
    val handler= CoroutineExceptionHandler { context,exception  ->
        println("Caught $exception")
        if(exception is HttpException){
            when(exception.code()){
                400->{
                    println("error 400 and bad response")
                    viewModelScope.launch {
                        sharedFlow.emit("error 400 and bad response")
                    }
                }
                500->{
                    println("internal server error")
                    viewModelScope.launch {
                        sharedFlow.emit("internal server error")
                    }
                }
                401->{
                    println("un authorized")
                    viewModelScope.launch {
                        sharedFlow.emit("Caught un authorized")
                    }
                }
            }
        }
    }
}