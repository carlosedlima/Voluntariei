package com.facens.acedevelop.voluntariei.data.datasource

import android.util.Log
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UserDataSource
import com.facens.acedevelop.voluntariei.data.interfaces.OngInterface
import com.facens.acedevelop.voluntariei.data.interfaces.UserInterface
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
            request.create(UserInterface::class.java).createUser(user).listen(
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
            request.create(UserInterface::class.java).getUser(id).listen(
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

    override suspend fun login(login: LoginRequest): User? {
        return suspendCoroutine { continuation ->
            request.create(UserInterface::class.java).loginUser(login).listen(
                onSuccess = { response ->
                    if (response.isSuccessful) {
                        val user:User? = response.body()
                        Log.d("Objeto",user.toString())
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
            request.create(UserInterface::class.java).updateUser(user.id!!).listen(
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