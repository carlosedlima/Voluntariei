package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong

interface OngDataSource {

    suspend fun updateOng(user: Ong):Ong

    suspend fun registerOng(user: Ong): Ong

    suspend fun getOng(id:Int): Ong

    suspend fun deleteOng(id: Int): Boolean

    suspend fun login(login:LoginRequest): Ong?
}