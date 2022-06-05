package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventoDataSource
import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.di.Request.listen
import com.facens.acedevelop.voluntariei.data.interfaces.EventoInterface
import com.facens.acedevelop.voluntariei.data.interfaces.HelpInterface
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.domain.models.Help
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitEventoDataSource @Inject constructor(
    private val request:Retrofit
) : EventoDataSource {
    override suspend fun getEvents(): List<Evento> {
        return suspendCoroutine { continuation ->
            request.create(EventoInterface::class.java).getEvent().listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        val events = mutableListOf<Evento>()
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

    override suspend fun createEvent(evento: Evento): Evento {
        return suspendCoroutine { continuation ->
            request.create(EventoInterface::class.java).createEvent(evento).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(evento))
                    }
                }
            )
        }
    }

    override suspend fun deleteEvent(evento: Evento) {
        TODO("Not yet implemented")
    }


}