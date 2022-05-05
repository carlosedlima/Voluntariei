package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.User

interface UsuarioUseCase {
    suspend fun registerUser(user: User): User

    suspend fun getUser(id: Int): User

    suspend fun deleteUser(id: Int): Boolean
}