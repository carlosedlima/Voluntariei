package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.Evento
import retrofit2.Call
import retrofit2.http.*

interface EventoInterface {

    @GET("/evento")
    fun getEvent(): Call<MutableList<Evento>>

    @POST("/evento")
    fun createEvent():Call<MutableLiveData<Evento>>

    @PUT("/evento/{id}")
    fun updateEvent(@Path("id") id:Int):Call<MutableLiveData<Evento>>

    @DELETE("/evento/{id}")
    fun deleteEvent(@Path("id") id:Int):Call<MutableLiveData<Any>>

}