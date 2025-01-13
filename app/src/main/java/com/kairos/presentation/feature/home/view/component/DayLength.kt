package com.kairos.presentation.feature.home.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DayLength(

    lengthOfDay: String,
    remainingDay: String,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier,


        ) {
        Row {
            Text(text = "Length of day :  $lengthOfDay")
        }
        Row {
            Text(text = "Remaining daylight : $remainingDay ")
        }


    }


}


@Preview
@Composable
fun DayLengthPreview() {

    DayLength(lengthOfDay = "13H 12M", remainingDay = "9H 10M")

}