package com.example.bosta.REPOSITORY

import com.example.bosta.API.ApiService
import com.example.bosta.MODELS.City
import javax.inject.Inject

class CityRepository(private val apiService: ApiService) {
    suspend fun getCities(): List<City>? {
        val response = apiService.getAllDistricts()
        return if (response.isSuccessful) response.body()?.data else null
    }
}