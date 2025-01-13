package com.kairos.presentation.feature.home.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.kairos.R

@Composable
fun TempDisplay (

    city : String ,
    temprature : Int ,
    modifier: Modifier = Modifier ,
   /* state: HomeState*/




) {


    Column (modifier = modifier , ) {
        
        
        
        Row {
Icon(imageVector = ImageVector.vectorResource(id = R.drawable.sunny), contentDescription = null )
        }

        Row {
            Text(text = "$city")



        }
        Row {
            Text(text = " $temprature")

        }
    }


}

@Composable
@Preview
fun TempDisplayPreview ( )   { 
    
    TempDisplay(city = "Cairo ", temprature = 35)
}