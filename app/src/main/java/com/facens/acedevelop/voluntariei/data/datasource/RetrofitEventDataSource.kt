package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventDataSource
import com.facens.acedevelop.voluntariei.data.services.EventService
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.utils.listen
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitEventDataSource @Inject constructor(
    private val request:Retrofit
) : EventDataSource {
    override suspend fun getEvents(): List<Event> {
        return suspendCoroutine { continuation ->
            request.create(EventService::class.java).getEvent().listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val events = response.body()?.toList() ?: emptyList()
                        continuation.resumeWith(Result.success(events))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Erro ao recuperar os eventos: ${response.code()}")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun createEvent(event: Event): Event {
        return suspendCoroutine { continuation ->
            request.create(EventService::class.java).createEvent(event).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val createdEvent = response.body() ?: throw NullPointerException("Created event response body is null")
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Failed to create event")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

}