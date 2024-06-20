package com.facens.acedevelop.voluntariei.domain.di

import com.facens.acedevelop.voluntariei.domain.impl.EventUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.HelpUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.OngUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.UserUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.usecase.EventUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.HelpUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.UserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindHelpUseCase(useCase:HelpUseCaseImpl):HelpUseCase

    @Binds
    fun bindEventoUseCase(useCase: EventUseCaseImpl):EventUseCase

    @Binds
    fun bindUserUseCase(useCase: UserUseCaseImpl):UserUseCase

    @Binds
    fun bindOngUseCase(useCase:OngUseCaseImpl):OngUseCase
}