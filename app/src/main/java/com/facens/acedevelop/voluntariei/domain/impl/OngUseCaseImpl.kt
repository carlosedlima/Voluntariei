package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.OngRepository
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import javax.inject.Inject

class OngUseCaseImpl @Inject constructor(
    private val ongRepository: OngRepository
) : OngUseCase {
    override suspend fun registerOng(user: ONG): ONG = ongRepository.registerOng(user)

    override suspend fun getOng(id: Int): ONG = ongRepository.getOng(id)

    override suspend fun deleteOng(id: Int): Boolean = ongRepository.deleteOng(id)


}