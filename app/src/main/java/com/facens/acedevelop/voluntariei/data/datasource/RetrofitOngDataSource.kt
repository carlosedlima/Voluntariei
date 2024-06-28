package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource

import com.facens.acedevelop.voluntariei.data.services.OngService
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong
import com.facens.acedevelop.voluntariei.utils.listen
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitOngDataSource @Inject constructor(
    private val request: Retrofit
) : OngDataSource {

    override suspend fun updateOng(user: Ong): Ong {
        return suspendCoroutine { continuation ->
            request.create(OngService::class.java).updateOng(user.id!!).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        continuation.resumeWith(Result.success(user))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha o atualizar os dados")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun registerOng(user: Ong): Ong {
        return suspendCoroutine { continuation ->
            request.create(OngService::class.java).createOng(user).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        continuation.resumeWith(Result.success(user))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha ao cadastrar")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun getOng(id: Long): Ong {
        return suspendCoroutine { continuation ->
            request.create(OngService::class.java).getOng(id).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val ong: Ong = response.body()?.value!!
                        continuation.resumeWith(Result.success(ong))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha ao obter ONG")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun deleteOng(id: Long): Boolean {
        return suspendCoroutine { continuation ->
            request.create(OngService::class.java).deleteOng(id).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        continuation.resumeWith(Result.success(true))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha ao deletar")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun login(login: LoginRequest): Ong? {
        return suspendCoroutine { continuation ->
            request.create(OngService::class.java).loginOng(login).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val ong: Ong? = response.body()
                        continuation.resumeWith(Result.success(ong))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha no login")))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }
}