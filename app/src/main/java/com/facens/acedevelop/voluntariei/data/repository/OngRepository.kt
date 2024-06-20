package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong
import javax.inject.Inject

class OngRepository @Inject constructor(
    private val dataSource:OngDataSource
) {
    suspend fun registerOng(user: Ong): Ong = dataSource.registerOng(user)

    suspend fun getOng(id:Int): Ong = dataSource.getOng(id)

    suspend fun updateOng(user:Ong):Ong = dataSource.updateOng(user)

    suspend fun deleteOng(id: Int): Boolean = dataSource.deleteOng(id)

    suspend fun loginOng(login: LoginRequest):Ong? = dataSource.login(login)
}