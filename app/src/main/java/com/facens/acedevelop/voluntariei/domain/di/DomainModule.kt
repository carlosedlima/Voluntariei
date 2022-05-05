package com.facens.acedevelop.voluntariei.domain.di

import com.facens.acedevelop.voluntariei.domain.impl.EventoUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.HelpUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.OngUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.impl.UserUseCaseImpl
import com.facens.acedevelop.voluntariei.domain.usecase.EventoUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.HelpUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.UsuarioUseCase
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
    fun bindEventoUseCase(useCase: EventoUseCaseImpl):EventoUseCase

    @Binds
    fun bindUserUseCase(useCase: UserUseCaseImpl):UsuarioUseCase

    @Binds
    fun bindOngUseCase(useCase:OngUseCaseImpl):OngUseCase
}