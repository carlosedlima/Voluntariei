package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.models.User
import okhttp3.ResponseBody

interface OngDataSource {

    suspend fun updateOng(user: ONG):ONG

    suspend fun registerOng(user: ONG): ONG

    suspend fun getOng(id:Int): ONG

    suspend fun deleteOng(id: Int): Boolean

    suspend fun login(login:LoginRequest): ONG?
}