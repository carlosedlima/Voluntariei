package com.facens.acedevelop.voluntariei.data.di

import com.facens.acedevelop.voluntariei.data.datasource.RetrofitEventDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitHelpDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitOngDataSource
import com.facens.acedevelop.voluntariei.data.datasource.RetrofitUserDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.EventDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.HelpDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.UserDataSource
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
    fun bindEventDataSource(datasource:RetrofitEventDataSource):EventDataSource

    @Singleton
    @Binds
    fun bindUserDataSource(datasource:RetrofitUserDataSource):UserDataSource

    @Singleton
    @Binds
    fun bindOngDataSource(datasource:RetrofitOngDataSource):OngDataSource

}