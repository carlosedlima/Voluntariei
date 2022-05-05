package com.facens.acedevelop.voluntariei.domain.usecase

import com.facens.acedevelop.voluntariei.domain.models.Help

interface HelpUseCase {
    suspend fun getHelps(): List<Help>
}