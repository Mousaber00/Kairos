package com.kairos.data.remote

import com.kairos.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("onecall")
    suspend fun getAllWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey:  String = "e458d81824ca8cd85c01327409e255e5",

        ) : Flow<Result<WeatherResponse>>

}