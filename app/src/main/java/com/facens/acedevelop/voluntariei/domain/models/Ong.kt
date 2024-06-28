package com.facens.acedevelop.voluntariei.domain.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Ong (
    @SerializedName("id")  val id:Long? = 0,
    @SerializedName("nome")  val name:String?,
    @SerializedName("email") val email:String?,
    @SerializedName("senha") val password:String?,
):Serializable