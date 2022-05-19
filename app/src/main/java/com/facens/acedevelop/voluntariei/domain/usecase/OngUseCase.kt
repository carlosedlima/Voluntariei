package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.ONG


interface OngUseCase {
    suspend fun registerOng(user: ONG): ONG

    suspend fun updateOng(user: ONG):ONG

    suspend fun getOng(id: Int): ONG

    suspend fun deleteOng(id: Int): Boolean

    suspend fun login(login: LoginRequest): ONG?
}