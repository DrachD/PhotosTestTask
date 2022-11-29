package com.dmitriy.photostesttask.screens.main.tabs.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitriy.photostesttask.core_network.source.GeneralResponse
import com.dmitriy.photostesttask.core_network.source.photos.entities.GetPhotoResponseEntity
import com.dmitriy.photostesttask.model.photos.PhotoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _data = MutableLiveData<GetPhotoResponseEntity>()
    val data: LiveData<GetPhotoResponseEntity> = _data

    fun fetchPhotos() = viewModelScope.launch {

        when (val response = photoRepository.fetchPhotos()) {
            is GeneralResponse.Success -> {
                _data.postValue(response.data!!)
            }

            is GeneralResponse.Error -> {
                Log.d("logs", response.errorMessage.toString())
            }
        }
    }
}