package com.facens.acedevelop.voluntariei.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Event(
    @SerializedName("id")val id:Long,
    @SerializedName("nome")val nome:String,
    @SerializedName("descricao")val descricao:String,
    @SerializedName("data")val data: Date,
    @SerializedName("ong_id")val ong: Long,
) :Serializable
