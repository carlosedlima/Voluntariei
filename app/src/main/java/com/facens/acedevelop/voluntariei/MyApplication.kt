package com.facens.acedevelop.voluntariei

import android.app.Application
import com.facens.acedevelop.voluntariei.data.di.AppComponent
import com.facens.acedevelop.voluntariei.data.di.DaggerAppComponent
import com.facens.acedevelop.voluntariei.data.di.SharedPrefModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

}