package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("resposta") var result:String = ""
): Serializable

