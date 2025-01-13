package com.kairos.presentation.feature.home.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.kairos.presentation.feature.home.view.component.DayLength
import com.kairos.presentation.feature.home.view.component.TempDisplay
import com.kairos.presentation.feature.home.view.component.WeatherForecast
import com.kairos.presentation.feature.home.viewmodel.HomeViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.withContext
import timber.log.Timber

@Composable
fun HomeScreen(
    viewModel: HomeViewmodel = hiltViewModel()
) {

    val TAG ="HomeScreen"

    LaunchedEffect(key1 = Unit) {
        /*try {
            Log.d(TAG, "HomeScreen: ")

            // Assuming this fetches weather data asynchronously

                viewModel.getAllWeather(33.44,-94.04)



        } catch (e: Exception) {
            Timber.d("error message: ${e.message}")
        }*/

    }



    HomeContent()
}

@Composable
fun HomeContent() {
    Column {
        Row {
            TempDisplay(city = "Ciro", temprature = 30)
        }

        Row {
            WeatherForecast(time = "8:40AM", uv = 0, rainPercent = 0, windSpeed = 0)

        }
        Row {
            DayLength(lengthOfDay = "10H", remainingDay = "0")
        }

        AsyncImage(

            modifier = Modifier.size(100.dp),
            model = "https://openweathermap.org/img/wn/10d@2x.png",
            contentDescription = "WeatherIcon",


            )
    }


}

@Composable
@Preview(showSystemUi = true)
fun HomeContentPreview() {
    HomeContent()


}