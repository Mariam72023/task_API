package com.example.myapi.domain

import com.example.myapi.data.Repository

class SaveTokenUseCase (val repository: Repository=Repository()){
    fun saveToken(token:String){
        repository.saveToken(token)
    }
}