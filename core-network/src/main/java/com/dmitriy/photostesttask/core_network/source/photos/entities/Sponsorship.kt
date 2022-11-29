package com.dmitriy.photostesttask.core_network.source.photos.entities

data class Sponsorship(
    val impression_urls: List<String>,
    val sponsor: Sponsor,
    val tagline: String,
    val tagline_url: String
)