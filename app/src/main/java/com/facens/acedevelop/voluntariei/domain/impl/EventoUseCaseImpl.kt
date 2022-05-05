package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.EventRepository
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.domain.usecase.EventoUseCase
import javax.inject.Inject

class EventoUseCaseImpl @Inject constructor(
    private val eventRepository: EventRepository
) : EventoUseCase {

    override suspend fun getEvents(): List<Evento> = eventRepository.getEvents()

    override suspend fun createEvent(evento: Evento): Evento = eventRepository.createEvent(evento)

}