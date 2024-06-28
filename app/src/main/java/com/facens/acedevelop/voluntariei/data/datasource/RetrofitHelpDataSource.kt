package com.facens.acedevelop.voluntariei.data.datasource

import android.util.Log
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.HelpDataSource
import com.facens.acedevelop.voluntariei.data.services.HelpService
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.utils.listen
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitHelpDataSource @Inject constructor(
    private val request: Retrofit
) : HelpDataSource {

    override suspend fun getHelps(): List<Help> {
        return suspendCoroutine { continuation ->
            val service = request.create(HelpService::class.java)
            service.getHelps().listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val helps = response.body()?.toList() ?: emptyList()
                        continuation.resumeWith(Result.success(helps))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Erro ao recuperar as duvidas: ${response.code()} ${response.message()}")))
                    }
                },
                onError = { error ->
                    continuation.resumeWith(Result.failure(error))
                    Log.d("HelpRequest", "GetError: $error")
                }
            )
        }
    }

}