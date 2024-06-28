package com.facens.acedevelop.voluntariei.data.di

import com.facens.acedevelop.voluntariei.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPrefModule::class])
interface AppComponent {
    fun inject(application: MyApplication)
}