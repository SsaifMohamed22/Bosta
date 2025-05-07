package com.example.bosta.MODELS

data class City(
    val cityId: String,
    val cityName: String,
    val cityOtherName: String,
    val cityCode: String,
    val districts: List<District>,
    var isExpanded: Boolean = false
)
