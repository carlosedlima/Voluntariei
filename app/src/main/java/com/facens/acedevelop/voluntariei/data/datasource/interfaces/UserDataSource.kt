package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.User

interface UserDataSource {

    suspend fun registerUser(user:User):User

    suspend fun getUser(id:Int):User

    suspend fun deleteUser(id: Int):Boolean

    suspend fun login(login:LoginRequest):User?

    suspend fun updateUser(user: User): User

}