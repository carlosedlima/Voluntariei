package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource

import com.facens.acedevelop.voluntariei.data.interfaces.OngInterface
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.utils.listen
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitOngDataSource @Inject constructor(
    private val request: Retrofit
) : OngDataSource {
    override suspend fun updateOng(user: ONG): ONG {
        return suspendCoroutine { continuation ->
            request.create(OngInterface::class.java).updateOng(user.id!!).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun registerOng(user: ONG): ONG {
        return suspendCoroutine { continuation ->

            request.create(OngInterface::class.java).createOng(user).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }

    }

    override suspend fun getOng(id: Int): ONG {
        return suspendCoroutine { continuation ->
            request.create(OngInterface::class.java).getOng(id).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val user: ONG = response.body()?.value!!
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun deleteOng(id: Int): Boolean {
       return  suspendCoroutine { continuation ->
           request.create(OngInterface::class.java).deleteOng(id).listen(
               onSuccess = {response ->
                   if (response.isSuccessful){
                       continuation.resumeWith(Result.success(true))
                   }
               },
               onError = {error ->
                   continuation.resumeWith(Result.failure(error))
               }
           )
       }
    }

    override suspend fun login(login: LoginRequest): ONG? {
        return suspendCoroutine { continuation ->
            request.create(OngInterface::class.java).loginOng(login).listen(
                onSuccess ={ response ->
                    if(response.isSuccessful){
                        val ong: ONG? = response.body()
                        continuation.resumeWith(Result.success(ong))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

}