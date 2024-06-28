package com.facens.acedevelop.voluntariei.data.services

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.Event
import retrofit2.Call
import retrofit2.http.*

interface EventService {

    @GET("/events")
    fun getEvent(): Call<MutableList<Event>>

    @POST("/events")
    fun createEvent(@Body event: Event):Call<MutableLiveData<Event>>

    @PUT("/events/{id}")
    fun updateEvent(@Path("id") id:Long):Call<MutableLiveData<Event>>

    @DELETE("/events/{id}")
    fun deleteEvent(@Path("id") id:Long):Call<MutableLiveData<Any>>

}