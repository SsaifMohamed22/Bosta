package com.example.bosta.API

import com.example.bosta.MODELS.ApiResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("cities/getAllDistricts")
    suspend fun getAllDistricts(
        @Query("countryId") countryId: String = "60e4482c7cb7d4bc4849c4d5"
    ): retrofit2.Response<ApiResponse>}