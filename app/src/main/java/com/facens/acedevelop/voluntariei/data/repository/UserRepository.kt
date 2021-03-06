package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UsuarioDataSource
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dataSource: UsuarioDataSource
) {
    suspend fun registerUser(user: User): User = dataSource.registerUser(user)

    suspend fun updateUser(user: User): User = dataSource.updateUser(user)

    suspend fun getUser(id:Int): User = dataSource.getUser(id)

    suspend fun deleteUser(id: Int): Boolean = dataSource.deleteUser(id)

    suspend fun loginUser(login:LoginRequest):User? = dataSource.login(login)
}