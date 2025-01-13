package com.kairos.presentation.feature.home.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherForecast(
    time : String,
    uv : Int,
    rainPercent : Int,
    windSpeed : Int,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(text = "Time")
            Text(text = "$time")
        }
        Column {
            Text(text = "UV")
            Text(text = uv.toString())
        }
        Column {
            Text(text = "Rain")
            Text(text = "$rainPercent%")
        }
        Column {
            Text(text = "WS")
            Text(text = "$windSpeed M/S" )
        }
    }
}

@Preview
@Composable
fun WeatherForecastPreview(){
    WeatherForecast(time = "11:26 am", uv = 12, rainPercent = 21 , windSpeed = 22 )
}