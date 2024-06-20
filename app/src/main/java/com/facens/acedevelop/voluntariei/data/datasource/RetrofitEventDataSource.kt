package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventDataSource
import com.facens.acedevelop.voluntariei.data.interfaces.EventInterface
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
            request.create(EventInterface::class.java).getEvent().listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        val events = mutableListOf<Event>()
                        response.body()?.forEach { evento ->
                            events.add(evento)
                        }

                        continuation.resumeWith(Result.success(events))
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
            request.create(EventInterface::class.java).createEvent(event).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(event))
                    }
                }
            )
        }
    }

    override suspend fun deleteEvent(event: Event) {
        TODO("Not yet implemented")
    }


}