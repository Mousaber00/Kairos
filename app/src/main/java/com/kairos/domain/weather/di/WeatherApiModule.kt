package com.kairos.domain.weather.di

import com.kairos.data.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherApiModule {

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit) = retrofit.create(WeatherApi::class.java)


}