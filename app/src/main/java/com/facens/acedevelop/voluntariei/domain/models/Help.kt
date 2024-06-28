package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Help(
    @SerializedName("id")val id:Long,
    @SerializedName("titulo")val title:String,
    @SerializedName("descricao")val description:String,
):Serializable
