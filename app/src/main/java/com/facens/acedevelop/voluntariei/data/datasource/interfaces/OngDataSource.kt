package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong

interface OngDataSource {

    suspend fun updateOng(user: Ong):Ong

    suspend fun registerOng(user: Ong): Ong

    suspend fun getOng(id:Long): Ong

    suspend fun deleteOng(id: Long): Boolean

    suspend fun login(login:LoginRequest): Ong?
}