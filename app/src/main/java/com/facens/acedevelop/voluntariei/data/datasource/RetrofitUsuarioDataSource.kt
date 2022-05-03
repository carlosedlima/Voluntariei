package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UsuarioDataSource
import com.facens.acedevelop.voluntariei.domain.models.User

class RetrofitUsuarioDataSource : UsuarioDataSource {
    override suspend fun registerUser(user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(id: Int): User {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(id: Int): User {
        TODO("Not yet implemented")
    }
}