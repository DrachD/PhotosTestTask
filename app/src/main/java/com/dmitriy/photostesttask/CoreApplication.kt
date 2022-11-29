package com.dmitriy.photostesttask

import android.app.Application
import com.dmitriy.photostesttask.di.AppComponent
import com.dmitriy.photostesttask.di.DaggerAppComponent

class CoreApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}