package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.Evento

interface EventoUseCase {
    suspend fun getEvents(): List<Evento>
    suspend fun createEvent(evento: Evento):Evento

}