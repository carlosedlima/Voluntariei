package com.facens.acedevelop.voluntariei.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UsuarioDataSource
import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.di.Request.listen
import com.facens.acedevelop.voluntariei.data.interfaces.OngInterface
import com.facens.acedevelop.voluntariei.data.interfaces.UsuarioInterface
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.User
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitUsuarioDataSource @Inject constructor(
    private val request: Retrofit
): UsuarioDataSource {
    override suspend fun registerUser(user: User): User {
        return suspendCoroutine {continuation ->
            request.create(UsuarioInterface::class.java).createUser(user).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun getUser(id: Int): User {
        return suspendCoroutine {continuation ->
            request.create(UsuarioInterface::class.java).getUser(id).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        val user:User= response.body()?.value!!
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun deleteUser(id: Int): Boolean {
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

    override suspend fun login(login:LoginRequest): User? {
        return suspendCoroutine { continuation ->
            request.create(UsuarioInterface::class.java).loginUser(login).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val user:User? = response.body()
                        continuation.resumeWith(Result.success(user))
                    }
                } ,
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun updateUser(user: User): User {
        return  suspendCoroutine { continuation ->
            request.create(UsuarioInterface::class.java).updateUser(user.id!!).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }
}