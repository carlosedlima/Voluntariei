package com.facens.acedevelop.voluntariei.data.di

import com.facens.acedevelop.voluntariei.data.datasource.RetrofitEventoDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitHelpDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitOngDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitUsuarioDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventoDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.HelpDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UsuarioDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindHelpDataSource(datasource:RetrofitHelpDataSource):HelpDataSource

    @Singleton
    @Binds
    fun bindEventDataSource(datasource:RetrofitEventoDataSource):EventoDataSource

    @Singleton
    @Binds
    fun bindUserDataSource(datasource:RetrofitUsuarioDataSource):UsuarioDataSource

    @Singleton
    @Binds
    fun bindOngDataSource(datasource:RetrofitOngDataSource):OngDataSource

}