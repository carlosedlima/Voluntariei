package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.Event

interface EventDataSource {

    suspend fun getEvents():List<Event>

    suspend fun createEvent(event: Event):Event

}