package com.facens.acedevelop.voluntariei.domain.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ONG (
    @SerializedName("id")  val id:Int? = 0,
    @SerializedName("nome")  val name:String?,
    @SerializedName("email") val email:String?,
    @SerializedName("senha") val password:String?,
):Serializable