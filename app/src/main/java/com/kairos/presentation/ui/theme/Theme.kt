package com.kairos.presentation.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


private val LightColorSchene = AppColors (

    primaryBackground = White ,


)

private val DarkColorScheme = AppColors(

    primaryBackground = Gray,
)
val LocalAppColors = staticCompositionLocalOf <AppColors> {

    error("Color not provided " )
}

@Composable
fun AppTheme (
    darkTheme : Boolean = isSystemInDarkTheme(),
    content : @Composable () -> Unit


)

{val colors = if (darkTheme)  DarkColorScheme else LightColorSchene

    CompositionLocalProvider (LocalAppColors  provides colors    ) {
    MaterialTheme(
        content = content
    )


}


}
object  AppTheme {
    val colors : AppColors
    @Composable
    get () = LocalAppColors . current

}