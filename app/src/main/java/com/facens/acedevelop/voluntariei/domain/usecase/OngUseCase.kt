package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.ONG


interface OngUseCase {
    suspend fun registerOng(user: ONG): ONG

    suspend fun getOng(id: Int): ONG

    suspend fun deleteOng(id: Int): Boolean
}