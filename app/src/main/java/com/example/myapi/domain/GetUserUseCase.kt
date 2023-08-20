package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.users.UserModel

class GetUserUseCase(val repository: Repository= Repository()) {
    suspend fun getUsers():UserModel{
        return repository.getUsers()
    }
}