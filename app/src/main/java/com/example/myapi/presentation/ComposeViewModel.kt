package com.example.myapi.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myapi.data.model.LoginRequest
import com.example.myapi.data.model.ProductRequest
import com.example.myapi.data.model.users.User
import com.example.myapi.domain.*
import com.example.myapi.domain.model.CustomUiModel
import kotlinx.coroutines.launch

class ComposeViewModel(
    val getProductUseCase: GetProductUseCase = GetProductUseCase(),
    val addNewProductUseCase: AddNewProductUseCase = AddNewProductUseCase(),
    val deleteProductUseCase: DeleteProductUseCase = DeleteProductUseCase(),
    val updateProductUseCase: UpdateProductUseCase = UpdateProductUseCase(),
    val getUserUseCase: GetUserUseCase = GetUserUseCase(),
    val searchProductUseCase: SearchProductUseCase = SearchProductUseCase(),
    val loginUseCase: LoginUseCase = LoginUseCase(),
    val saveTokenUseCase: SaveTokenUseCase = SaveTokenUseCase(),
    val getTokenUseCase: GetTokenUseCase = GetTokenUseCase(),
) : BaseViewModel() {

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


    // val apiKey = "API_KEY"


    fun getUsers() {
        viewModelScope.launch {
            val users = getUserUseCase.getUsers()
            userList.value = users.users

        }
    }

    fun addProduct() {
        viewModelScope.launch {
            addNewProductUseCase.addNewProduct(ProductRequest("asd asd"))
        }
    }

    fun updateProduct() {
        viewModelScope.launch {
            updateProductUseCase.updateProduct(ProductRequest("asd asd"), 3)
        }
    }

    fun deleteProduct() {
        viewModelScope.launch {
            deleteProductUseCase.deleteProduct(5)
        }
    }

    fun searchForProduct() {
        try {
            viewModelScope.launch {
                val products = searchProductUseCase.searchForProduct("apple")
                productList.value = products
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun loginToken() {
        viewModelScope.launch(handler) {
            val login = loginUseCase.login(LoginRequest("kminchelle", "0lelplR"))
            saveTokenUseCase.saveToken(login.token)
            getTokenUseCase.getToken()?.let {
                getAuthProducts(it)
            }


        }
    }

    private fun getAuthProducts(token: String) {
        viewModelScope.launch(handler) {
            val products = getProductUseCase.getAuthProduct("Bearer $token")
            productList.value = products
        }
    }


}