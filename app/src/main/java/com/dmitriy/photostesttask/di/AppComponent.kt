package com.dmitriy.photostesttask.di

import com.dmitriy.photostesttask.core_network.di.SourceProviderModule
import com.dmitriy.photostesttask.screens.main.tabs.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    SourceProviderModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(fragment: HomeFragment)
}