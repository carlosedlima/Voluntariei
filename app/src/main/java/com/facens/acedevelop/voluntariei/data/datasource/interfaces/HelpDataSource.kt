package com.facens.acedevelop.voluntariei.data.datasource.interfaces

import com.facens.acedevelop.voluntariei.domain.models.Help

interface HelpDataSource {

    suspend fun getHelps(): List<Help>
}