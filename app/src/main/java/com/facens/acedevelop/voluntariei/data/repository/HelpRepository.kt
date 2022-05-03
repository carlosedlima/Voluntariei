package com.facens.acedevelop.voluntariei.data.repository

import com.facens.acedevelop.voluntariei.data.datasource.interfaces.HelpDataSource
import com.facens.acedevelop.voluntariei.domain.models.Help
import javax.inject.Inject

class HelpRepository @Inject constructor(
    private val  dataSource: HelpDataSource
) {
    suspend fun getHelp():List<Help> = dataSource.getHelps()
}