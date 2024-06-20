package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.Event

interface EventUseCase {
    suspend fun getEvents(): List<Event>
    suspend fun createEvent(event: Event):Event

}