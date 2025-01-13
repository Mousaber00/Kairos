package com.kairos.domain.weather.model

import com.google.gson.annotations.SerializedName
import com.kairos.data.remote.Current
import com.kairos.data.remote.Daily
import com.kairos.data.remote.Hourly
import com.kairos.data.remote.Minutely

data class Weather(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: Current,
    val hourly: List<Hourly>,
    val daily: List<Daily>,

)
