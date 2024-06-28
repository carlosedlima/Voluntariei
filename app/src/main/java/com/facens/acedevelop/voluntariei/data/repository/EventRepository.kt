package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventDataSource
import com.facens.acedevelop.voluntariei.domain.models.Event
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val eventoDataSource: EventDataSource
) {
    suspend fun getEvents(): List<Event> = eventoDataSource.getEvents()

    suspend fun createEvent(event: Event):Event = eventoDataSource.createEvent(event)


}