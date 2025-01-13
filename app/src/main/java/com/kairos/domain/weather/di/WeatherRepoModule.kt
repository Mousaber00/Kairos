package com.kairos.domain.weather.di

import com.kairos.domain.weather.repo.WeatherRepo
import com.kairos.domain.weather.repo.WeatherRepoImpl
import com.kairos.data.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)
object WeatherRepoModule{

    @Provides
    @Singleton
    fun ProvideWeatherRepoModule (weatherApi: WeatherApi) : WeatherRepo {
        return WeatherRepoImpl(weatherApi)



    }


}







