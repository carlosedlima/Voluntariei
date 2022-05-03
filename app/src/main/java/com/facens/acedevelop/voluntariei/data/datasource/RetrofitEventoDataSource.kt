package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventoDataSource
import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.di.Request.listen
import com.facens.acedevelop.voluntariei.data.interfaces.EventoInterface
import com.facens.acedevelop.voluntariei.data.interfaces.HelpInterface
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.domain.models.Help
import kotlin.coroutines.suspendCoroutine

class RetrofitEventoDataSource(
    val request:Request
) : EventoDataSource {
    override suspend fun getEvents(): List<Evento> {
        return suspendCoroutine { continuation ->
            request.create(EventoInterface::class.java).getHelps().listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        val helps = mutableListOf<Help>()
                        response.body()?.forEach { help ->
                            helps.add(help)
                        }

                        continuation.resumeWith(Result.success(helps))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun createEvent(evento: Evento): Evento {
        TODO("Not yet implemented")
    }

    override suspend fun deleteEvent(evento: Evento) {
        TODO("Not yet implemented")
    }


}