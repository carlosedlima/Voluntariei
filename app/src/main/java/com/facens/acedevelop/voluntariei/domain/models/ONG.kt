package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ONG (
    @SerializedName("id")val id:Int?,
    @SerializedName("nome")val name:String,
    @SerializedName("email")val email:String,
    @SerializedName("senha")val password:String,
    @SerializedName("cnpj")val cnpj:String,
):Serializable