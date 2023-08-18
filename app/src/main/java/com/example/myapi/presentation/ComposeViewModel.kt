package com.example.myapi.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myapi.data.model.LoginRequest
import com.example.myapi.data.model.ProductRequest
import com.example.myapi.data.model.users.User
import com.example.myapi.data.network.NetworkServices
import com.example.myapi.presentation.model.CustomUiModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComposeViewModel : BaseViewModel() {
    var textCheck = mutableStateOf("checked")
    var textValue =
        mutableStateOf("")
    var checked = mutableStateOf(true)
    fun textHasBeenWritten(newText: String) {
        if (newText.contains('@'))

            textValue.value = newText.replace('@', ' ').trim()
        else
            textValue.value = newText
    }

    var productList = mutableStateOf<List<CustomUiModel>>(emptyList())
    var userList = mutableStateOf<List<User>>(emptyList())
    var retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val network = retrofit.create(NetworkServices::class.java)
   // val apiKey = "API_KEY"


    fun getUsers() {
        viewModelScope.launch {
            val users = network.getUserList()
            userList.value = users.users

        }
    }

    fun addProduct() {
        viewModelScope.launch {
            network.addNewProduct(ProductRequest("asd asd"))
        }
    }

    fun updateProduct() {
        viewModelScope.launch {
            network.updateProduct(ProductRequest("asd asd"), 3)
        }
    }

    fun deleteProduct() {
        viewModelScope.launch {
            network.deleteProduct(5)
        }
    }

    fun searchForProduct() {
        try {
            viewModelScope.launch {
                val products = network.searchForProductList("apple")
                productList.value = products.products.map {
                    CustomUiModel(headlineText = it.title, supportingText = it.description)
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun loginToken() {
        viewModelScope.launch(handler) {
            val login = network.login(LoginRequest("kminchelle", "0lelplR"))
            getAuthProducts(login.token)
        }
    }

   private fun getAuthProducts(token: String) {
        viewModelScope.launch (handler){
            val products = network.getProductList("Bearer $token")
            productList.value = products.products.map {
                CustomUiModel(headlineText = it.title, supportingText = it.description)
            }
        }
    }
}