package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.LoginRequest
import com.example.myapi.data.model.LoginResponse

class LoginUseCase(val repository: Repository= Repository()) {
    suspend fun login(loginRequest: LoginRequest):LoginResponse{
        return repository.login(loginRequest)
    }
}