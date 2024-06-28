package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id") val id: Long?,
    @SerializedName("nome") val name:String,
    @SerializedName("email") val email:String,
    @SerializedName("senha") val password:String,
    @SerializedName("cpf") val cpf:String,
):Serializable