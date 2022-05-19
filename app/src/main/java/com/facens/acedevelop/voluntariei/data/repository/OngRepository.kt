package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.ONG
import javax.inject.Inject

class OngRepository @Inject constructor(
    private val dataSource:OngDataSource
) {
    suspend fun registerOng(user: ONG): ONG = dataSource.registerOng(user)

    suspend fun getOng(id:Int): ONG = dataSource.getOng(id)

    suspend fun deleteOng(id: Int): Boolean = dataSource.deleteOng(id)

    suspend fun loginOng(login: LoginRequest):ONG? = dataSource.login(login)
}