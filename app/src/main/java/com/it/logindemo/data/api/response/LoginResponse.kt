package com.it.logindemo.data.api.response
import com.google.gson.annotations.SerializedName
 class LoginResponse(
     @SerializedName("token")
     var token: String
)
