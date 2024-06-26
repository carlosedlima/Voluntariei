package com.facens.acedevelop.voluntariei.data.services

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong
import retrofit2.Call
import retrofit2.http.*

interface OngService {

    @GET("/ongs/{id}")
    fun getOng(@Path("id")id:Long):Call<MutableLiveData<Ong>>

    @DELETE("/ongs/{id}")
    fun deleteOng(@Path("id")id:Long):Call<MutableLiveData<Boolean>>

    @POST("/ongs")
    fun createOng(@Body ong:Ong): Call<MutableLiveData<Boolean>>

    @PUT("/ongs/{id}")
    fun updateOng(@Path("id")id: Long):Call<MutableLiveData<Ong>>

    @POST("/ongs/login")
    fun loginOng(@Body login: LoginRequest):Call<Ong>
}