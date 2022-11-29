package com.dmitriy.photostesttask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dmitriy.photostesttask.model.photos.PhotoRepository
import com.dmitriy.photostesttask.screens.main.tabs.home.HomeViewModel
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val repository: PhotoRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}