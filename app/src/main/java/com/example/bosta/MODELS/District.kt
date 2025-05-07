package com.example.bosta.MODELS

data class District(
    val districtId: String,
    val districtName: String,
    val districtOtherName: String,
    val pickupAvailability: Boolean,
    val dropOffAvailability: Boolean,
    val coverage: String
)