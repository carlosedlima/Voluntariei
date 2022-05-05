package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.RetrofitEventoDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventoDataSource
import com.facens.acedevelop.voluntariei.domain.models.Evento
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val eventoDataSource: EventoDataSource
) {
    suspend fun getEvents(): List<Evento> = eventoDataSource.getEvents()

    suspend fun createEvent(event: Evento):Evento = eventoDataSource.createEvent(event)

}