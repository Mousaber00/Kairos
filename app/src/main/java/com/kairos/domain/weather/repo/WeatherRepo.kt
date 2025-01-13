package com.kairos.domain.weather.repo

import com.kairos.data.remote.WeatherResponse
import com.kairos.presentation.common.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepo  {

    suspend fun getAllWeather (lat :Double , lon : Double , )  : Flow<Result< WeatherResponse>>


}


