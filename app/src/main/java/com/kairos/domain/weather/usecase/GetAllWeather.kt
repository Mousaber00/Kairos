package com.kairos.domain.weather.usecase

import android.util.Log
import com.kairos.data.remote.toWeather
import com.kairos.data.remote.util.GeneralUtility
import com.kairos.domain.weather.model.Weather
import com.kairos.domain.weather.repo.WeatherRepo
import com.kairos.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetAllWeather @Inject constructor(
    private val weatherRepo: WeatherRepo
) {

    private val TAG ="e"

    operator fun invoke(lat: Double, lon: Double): Flow<Result<Weather>> = flow {
        weatherRepo.getAllWeather(lat, lon).collect { result ->
            when (result) {
                is Result.Loading -> emit(Result.Loading())
                is Result.Success -> try {
                    val weather = result.data.toWeather()
                    emit(Result.Success(weather))
                } catch (e: Exception) {
                    emit(Result.Error(GeneralUtility.dataError))
                }

                is Result.Error ->{
                    emit(Result.Error(GeneralUtility.dataError))
                }

            }
        }
    }

}