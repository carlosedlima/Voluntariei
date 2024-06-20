package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.EventRepository
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.domain.usecase.EventUseCase
import javax.inject.Inject

class EventUseCaseImpl @Inject constructor(
    private val eventRepository: EventRepository
) : EventUseCase {

    override suspend fun getEvents(): List<Event> = eventRepository.getEvents()

    override suspend fun createEvent(event: Event): Event = eventRepository.createEvent(event)

}