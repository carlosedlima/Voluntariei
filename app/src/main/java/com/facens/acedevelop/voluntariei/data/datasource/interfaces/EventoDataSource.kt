package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.Evento

interface EventoDataSource {

    suspend fun getEvents():List<Evento>

    suspend fun createEvent(evento: Evento):Evento

    suspend fun deleteEvent(evento: Evento)
}