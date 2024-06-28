package com.facens.acedevelop.voluntariei.data.datasource

import android.util.Log
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UserDataSource
import com.facens.acedevelop.voluntariei.data.services.OngService
import com.facens.acedevelop.voluntariei.data.services.UserService
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.utils.listen
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitUserDataSource @Inject constructor(
    private val request: Retrofit
): UserDataSource {
    override suspend fun registerUser(user: User): User {
        return suspendCoroutine {continuation ->
            request.create(UserService::class.java).createUser(user).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
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

    override suspend fun getUser(id: Long): User {
        return suspendCoroutine {continuation ->
            request.create(UserService::class.java).getUser(id).listen(
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

    override suspend fun deleteUser(id: Long): Boolean {
        return  suspendCoroutine { continuation ->
            request.create(OngService::class.java).deleteOng(id).listen(
                onSuccess = {response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(true))
                    } else {
                        continuation.resumeWith(Result.failure(Exception("Falha ao deletar")))
                    }
                },
                onError = {error ->
                    continuation.resumeWith(Result.failure(error))
                }
            )
        }
    }

    override suspend fun login(login: LoginRequest): User? {
        return suspendCoroutine { continuation ->
            request.create(UserService::class.java).loginUser(login).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val user:User? = response.body()
                        continuation.resumeWith(Result.success(user))
                    }else{
                        continuation.resumeWith(Result.failure(Exception("Falha no login")))
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
            request.create(UserService::class.java).updateUser(user.id!!).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
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
}