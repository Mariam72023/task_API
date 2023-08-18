package com.example.myapi.data.model.users

data class UserModel(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)