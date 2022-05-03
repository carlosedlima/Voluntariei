package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.models.User

interface OngDataSource {

    suspend fun registerOng(user: ONG): ONG

    suspend fun getOng(id:Int): ONG

    suspend fun deleteOng(id: Int): ONG

}