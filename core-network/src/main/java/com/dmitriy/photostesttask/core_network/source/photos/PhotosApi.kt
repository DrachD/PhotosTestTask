package com.dmitriy.photostesttask.core_network.source.photos

import com.dmitriy.photostesttask.core_network.source.photos.entities.GetPhotoResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    //@GET("photos/?client_id=f_J95lRzoaeZ4ytKP_Z7cTDGFVorUFUcUA8OHZmnLHw")
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") api_key: String
    ): Response<GetPhotoResponseEntity>
}