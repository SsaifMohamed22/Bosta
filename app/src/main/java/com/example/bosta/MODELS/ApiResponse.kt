package com.example.bosta.MODELS

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: List<City>
)
