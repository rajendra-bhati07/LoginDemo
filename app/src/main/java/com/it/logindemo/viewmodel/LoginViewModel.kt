package com.it.logindemo.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.it.logindemo.data.api.ApiClient
import com.it.logindemo.data.api.methods.UserApi
import com.it.logindemo.data.api.request.LoginRequest
import com.it.logindemo.data.api.response.BaseResponse
import com.it.logindemo.data.api.response.LoginResponse
import com.it.logindemo.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val loginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()

    fun loginUser(email: String, pwd: String) {

        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(
                    email = email,
                    password = pwd
                )
                val response = userRepo.loginUser(loginRequest = loginRequest)
                loginResult.value = BaseResponse.Success(response?.body())


            } catch (ex: Exception) {
                loginResult.value = BaseResponse.Error(ex.message)
            }
        }
    }



}