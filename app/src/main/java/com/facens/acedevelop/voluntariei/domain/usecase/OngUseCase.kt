package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong


interface OngUseCase {
    suspend fun registerOng(user: Ong): Ong

    suspend fun updateOng(user: Ong):Ong

    suspend fun getOng(id: Long): Ong

    suspend fun deleteOng(id: Long): Boolean

    suspend fun login(login: LoginRequest): Ong?
}