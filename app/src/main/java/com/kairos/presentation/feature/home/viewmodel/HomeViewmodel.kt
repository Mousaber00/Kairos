package com.kairos.presentation.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kairos.data.remote.WeatherResponse
import com.kairos.domain.weather.model.Weather
import com.kairos.domain.weather.usecase.GetAllWeather
import com.kairos.presentation.common.Result
import com.kairos.presentation.feature.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    val getAllWeather: GetAllWeather
) : ViewModel() {


    private val TAG = "HomeViewmodel"


    init {
        getAllWeather(33.44, -90.04)
    }
    fun getAllWeather(lat: Double, lon: Double) {
        try {
            viewModelScope.launch {
                getAllWeather.invoke(lat, lon).collect { response ->
                    when (response) {
                        is Result.Loading -> {
                            Log.d(TAG, "getAllWeather: ${response}")

                        }

                        is Result.Error -> {
                            Log.d(TAG, "getAllWeather: ${response.error}")

                        }
                        is Result.Success -> {
                            Log.d(TAG, "getAllWeather: ${response.data}")
                        }
                    }

                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "msg: ${e.message}")
        }
    }


}