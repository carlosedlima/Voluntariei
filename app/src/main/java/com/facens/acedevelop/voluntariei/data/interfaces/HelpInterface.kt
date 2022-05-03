package com.facens.acedevelop.voluntariei.data.interfaces

import com.facens.acedevelop.voluntariei.domain.models.Help
import retrofit2.Call
import retrofit2.http.GET

interface HelpInterface {


    @GET("/ajudas")
    fun getHelps(): Call<MutableList<Help>>

}