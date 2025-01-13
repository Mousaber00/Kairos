package com.kairos.presentation.feature.home.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun RainWarning (
    RainPrecent : Int , 
    ExpTime : String ,
    
    


)  {
    
    Column {
        Row {
            Text(text = "Warning")
            
        }
        Row {
            Column {
                Text(text = "RAin")
                Text(text = "$RainPrecent")


            }
            Column {
                Text(text = "EXP.Time")
                Text(text = "$ExpTime")
            }
        }
        Row {
            Text(text = "Expecting Rainfall")
        }

    }


    
    
    
    
}

@Composable

@Preview(showSystemUi = true)
fun RainWarningPreview () {
    RainWarning(RainPrecent = 89, ExpTime = "696")

}