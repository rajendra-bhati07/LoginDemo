package com.it.logindemo.data.api.methods

import com.it.logindemo.data.api.ApiClient
import com.it.logindemo.data.api.request.LoginRequest
import com.it.logindemo.data.api.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}