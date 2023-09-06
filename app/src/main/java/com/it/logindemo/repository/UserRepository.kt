package com.it.logindemo.repository

import com.it.logindemo.data.api.methods.UserApi
import com.it.logindemo.data.api.request.LoginRequest
import com.it.logindemo.data.api.response.LoginResponse
import retrofit2.Response

class UserRepository {

   suspend fun loginUser(loginRequest:LoginRequest): Response<LoginResponse>? {
      return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}