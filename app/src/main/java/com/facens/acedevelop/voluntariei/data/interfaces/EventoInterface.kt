package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.Evento
import retrofit2.Call
import retrofit2.http.*

interface EventoInterface {

    @GET("/events")
    fun getEvent(): Call<MutableList<Evento>>

    @POST("/events")
    fun createEvent(@Body event:Evento):Call<MutableLiveData<Evento>>

    @PUT("/events/{id}")
    fun updateEvent(@Path("id") id:Int):Call<MutableLiveData<Evento>>

    @DELETE("/events/{id}")
    fun deleteEvent(@Path("id") id:Int):Call<MutableLiveData<Any>>

}