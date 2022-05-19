package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginRequest(
    @SerializedName("email") val email:String,
    @SerializedName("senha") val pass:String,
) : Serializable
