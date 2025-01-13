package com.kairos.data.remote

import com.google.gson.annotations.SerializedName
import com.kairos.domain.weather.model.Weather

data class WeatherResponse(

        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lon")
        val lon: Double,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("timezone_offset")
        val timezoneOffset: Int,
        @SerializedName("current")
        val current: Current,
        @SerializedName("minutely")
        val minutely: List<Minutely>,
        @SerializedName("hourly")
        val hourly: List<Hourly>,
        @SerializedName("daily")
        val daily: List<Daily>,
        /*@SerializedName("alerts")
        val alerts: Alerts,*/
        )


    data class Current(

        @SerializedName("dt")
        val currentDt: Long,
        @SerializedName("sunrise")
        val currentSunrise: Long,
        @SerializedName("sunset")
        val currentSunset: Long,
        @SerializedName("temp")
        val currentTemp: Double,
        @SerializedName("feels_like")
        val currentFeelsLike: Double,
        @SerializedName("pressure")
        val currentPressure: Int,
        @SerializedName("humidity")
        val currentHumidity: Int,
        @SerializedName("dew_point")
        val currentDewPoint: Double,
        @SerializedName("uvi")
        val currentUvi: Double,
        @SerializedName("clouds")
        val currentClouds: Int,
        @SerializedName("visibility")
        val currentVisibility: Int,
        @SerializedName("wind_speed")
        val currentWindSpeed: Double,
        @SerializedName("wind_deg")
        val currentWindDeg: Int,
        @SerializedName("wind_gust")
        val currentWindGust: Double,
        @SerializedName("weather")
        val currentWeather: List<CurrentWeather>, )

    data class CurrentWeather(

        @SerializedName("id")
        val currentWeatherId: Int,
        @SerializedName("main")
        val currentWeatherMain: String,
        @SerializedName("description")
        val currentWeatherDescription: String,
        @SerializedName("icon")
        val currentWeatherIcon: String, )

    data class Minutely (
        @SerializedName("dt")
        val minutelyDt: Long,
        @SerializedName("precipitation")
        val minutelyPrecipitation: Int,
    )

    data class Hourly(

        @SerializedName("dt")
        val hourlyDt: Long,
        @SerializedName("temp")
        val hourlyTemp: Double,
        @SerializedName("feels_like")
        val hourlyFeelsLike: Double,
        @SerializedName("pressure")
        val hourlyPressure: Int,
        @SerializedName("humidity")
        val hourlyHumidity: Int,
        @SerializedName("dew_point")
        val hourlyDewPoint: Double,
        @SerializedName("uvi")
        val hourlyUvi: Double,
        @SerializedName("clouds")
        val hourlyClouds: Int,
        @SerializedName("visibility")
        val hourlyVisibility: Int,
        @SerializedName("wind_speed")
        val hourlyWindSpeed: Double,
        @SerializedName("wind_deg")
        val hourlyWindDeg: Int,
        @SerializedName("wind_gust")
        val hourlyWindGust: Double,
        @SerializedName("pop")
        val hourlyPop: Double,
        @SerializedName("weather")
        val hourlyWeather: List<HourlyWeather>,
    )
    data class HourlyWeather (
        @SerializedName("id")
        val hourlyId: Int,
        @SerializedName("main")
        val hourlyWeatherMain: String,
        @SerializedName("description")
        val hourlyWeatherDescription: String,
        @SerializedName("icon")
        val hourlyWeatherIcon: String,
    )


    data class Daily(
        @SerializedName("dt")
        val dailyDt: Long,
        @SerializedName("sunset")
        val dailySunSet: Long,
        @SerializedName("moonrise")
        val dailyMoonRise: Long,
        @SerializedName("moonset")
        val dailyMoonSet: Long,
        @SerializedName("moon_phase")
        val dailyMoonPhase: Double,
        @SerializedName("pressure")
        val dailyPressure: Int,
        @SerializedName("humidity")
        val dailyHumidity: Int,
        @SerializedName("dew_point")
        val dailyDewPoint: Double,
        @SerializedName("wind_speed")
        val dailyWindSpeed: Double,
        @SerializedName("wind_deg")
        val dailyWindDeg: Int,
        @SerializedName("wind_gust")
        val dailyWindGust: Double,
        @SerializedName("clouds")
        val dailyClouds: Int,
        @SerializedName("pop")
        val dailyPop: Double,
        @SerializedName("rain")
        val dailyRain: Double,
        @SerializedName("uvi")
        val dailyUvi: Double,
        @SerializedName("summary")
        val dailySummary:String,
        @SerializedName("temp")
        val dailyTemp: DailyTemp,
        @SerializedName("feels_like")
        val dailyFeelsLike: DailyFeelsLike,
        @SerializedName("weather")
        val dailyWeather: List<DailyWeather>,

        )

    data class DailyWeather (
        @SerializedName("id")
        val dailyId: Int,
        @SerializedName("main")
        val dailyMain: String,
        @SerializedName("description")
        val dailyDescription: String,
        @SerializedName("icon")
        val dailyIcon: String,
    )
    data class DailyFeelsLike(
        @SerializedName("day")
        val dailyDay: Double,
        @SerializedName("night")
        val dailyNight: Double,
        @SerializedName("eve")
        val dailyEve: Double,
        @SerializedName("morn")
        val dailyMorn: Double,
    )

    data class DailyTemp (
        @SerializedName("day")
        val tempDay: Double,
        @SerializedName("min")
        val tempMin: Double,
        @SerializedName("max")
        val tempMax: Double,
        @SerializedName("night")
        val tempNight: Double,
        @SerializedName("eve")
        val tempEve: Double,
        @SerializedName("morn")
        val tempMorn: Double,
    )

    data class Alerts(
        @SerializedName("sender_name")
        val alertsSenderName: String,
        @SerializedName("event")
        val alertsEvent: String,
        @SerializedName("start")
        val alertsStart: Long,
        @SerializedName("end")
        val alertsEnd: Long,
        @SerializedName("description")
        val alertsDescription: String,
        //@SerializedName("tags")
        //val alertsTags: List<>,
    )

    fun WeatherResponse.toWeather() = Weather(
        lat = lat,
        lon = lon,
        hourly = hourly,
        current = current,
        daily = daily,
        timezoneOffset = timezoneOffset,
        timezone = timezone,
    )
