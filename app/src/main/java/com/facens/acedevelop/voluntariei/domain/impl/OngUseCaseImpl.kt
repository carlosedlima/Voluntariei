package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.OngRepository
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.Ong
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import javax.inject.Inject

class OngUseCaseImpl @Inject constructor(
    private val ongRepository: OngRepository
) : OngUseCase {
    override suspend fun registerOng(user: Ong): Ong = ongRepository.registerOng(user)

    override suspend fun updateOng(user: Ong): Ong = ongRepository.updateOng(user)

    override suspend fun getOng(id: Long): Ong = ongRepository.getOng(id)

    override suspend fun deleteOng(id: Long): Boolean = ongRepository.deleteOng(id)

    override suspend fun login(login: LoginRequest): Ong? = ongRepository.loginOng(login)


}