package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.ONG
import retrofit2.Call
import retrofit2.http.*

interface OngInterface {

    @GET("/ong/{id}")
    fun getOng(@Path("id")id:Int):Call<MutableLiveData<ONG>>

    @DELETE("/ong/{id}")
    fun deleteOng(@Path("id")id:Int):Call<MutableLiveData<Boolean>>

    @POST("/ong")
    fun createOng(@Body ong:ONG): Call<MutableLiveData<Boolean>>

    @PUT("/ong/{id}")
    fun updateOng(@Path("id")id: Int):Call<MutableLiveData<ONG>>
}