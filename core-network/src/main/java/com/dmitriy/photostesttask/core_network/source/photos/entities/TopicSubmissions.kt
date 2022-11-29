package com.dmitriy.photostesttask.core_network.source.photos.entities

import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("architecture-interior") val architecture_interior: ArchitectureInterior,
    val experimental: Experimental,
    val nature: Nature,
    val spirituality: Spirituality
)