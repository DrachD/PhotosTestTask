package com.dmitriy.photostesttask.model.photos

import com.dmitriy.photostesttask.core_network.Constants
import com.dmitriy.photostesttask.core_network.source.base.CoreRetrofitSource
import com.dmitriy.photostesttask.core_network.source.photos.PhotosApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photosApi: PhotosApi
) : CoreRetrofitSource() {

    suspend fun fetchPhotos() = wrapRetrofitException {
        photosApi.getPhotos("f_J95lRzoaeZ4ytKP_Z7cTDGFVorUFUcUA8OHZmnLHw")
    }
}