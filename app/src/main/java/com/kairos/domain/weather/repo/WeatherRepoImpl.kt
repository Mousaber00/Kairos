package com.kairos.domain.weather.repo

import com.kairos.data.remote.WeatherResponse
import com.kairos.data.remote.WeatherApi
import com.kairos.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
  private val weatherApi: WeatherApi
): WeatherRepo {

    override suspend fun getAllWeather(lat: Double, lon: Double):Flow<Result< WeatherResponse>> {
        return weatherApi.getAllWeatherData(lat, lon)

    }


}