package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.domain.models.ONG

class RetrofitOngDataSource : OngDataSource {
    override suspend fun registerOng(user: ONG): ONG {
        TODO("Not yet implemented")
    }

    override suspend fun getOng(id: Int): ONG {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOng(id: Int): ONG {
        TODO("Not yet implemented")
    }
}