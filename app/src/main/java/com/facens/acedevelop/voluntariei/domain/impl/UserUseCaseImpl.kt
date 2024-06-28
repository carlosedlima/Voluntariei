package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.UserRepository
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.domain.usecase.UserUseCase
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val repository: UserRepository
): UserUseCase {

    override suspend fun registerUser(user: User): User = repository.registerUser(user)

    override suspend fun updateUser(user: User): User = repository.updateUser(user)

    override suspend fun getUser(id: Long): User = repository.getUser(id)

    override suspend fun deleteUser(id: Long): Boolean = repository.deleteUser(id)

    override suspend fun login(login: LoginRequest): User? = repository.loginUser(login)

}