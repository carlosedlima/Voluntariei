package com.facens.acedevelop.voluntariei.data.services

import com.facens.acedevelop.voluntariei.domain.models.Help
import retrofit2.Call
import retrofit2.http.GET

interface HelpService {


    @GET("/help")
    fun getHelps(): Call<MutableList<Help>>

}