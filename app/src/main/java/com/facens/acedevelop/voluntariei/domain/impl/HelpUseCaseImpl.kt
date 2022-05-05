package com.facens.acedevelop.voluntariei.domain.impl

import com.facens.acedevelop.voluntariei.data.repository.HelpRepository
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.domain.usecase.HelpUseCase
import javax.inject.Inject

class HelpUseCaseImpl @Inject constructor(
    private val helpRepository: HelpRepository
): HelpUseCase {
    override suspend fun getHelps(): List<Help> {
        return helpRepository.getHelps()
    }

}