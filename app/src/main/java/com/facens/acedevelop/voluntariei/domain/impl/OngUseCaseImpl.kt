package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.OngRepository
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import javax.inject.Inject

class OngUseCaseImpl @Inject constructor(
    private val ongRepository: OngRepository
) : OngUseCase {
    override suspend fun registerOng(user: ONG): ONG = ongRepository.registerOng(user)

    override suspend fun updateOng(user: ONG): ONG = ongRepository.updateOng(user)

    override suspend fun getOng(id: Int): ONG = ongRepository.getOng(id)

    override suspend fun deleteOng(id: Int): Boolean = ongRepository.deleteOng(id)

    override suspend fun login(login: LoginRequest): ONG? = ongRepository.loginOng(login)


}