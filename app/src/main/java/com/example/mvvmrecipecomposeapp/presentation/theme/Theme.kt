package com.example.mvvmrecipecomposeapp.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mvvmrecipecomposeapp.presentation.components.CircularIndeterminateProgressBar
import com.example.mvvmrecipecomposeapp.presentation.components.DefaultSnackbar

private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Black2,
    secondary = Color.White,
    secondaryVariant = Teal300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black2,
)

private val DarkThemeColors = darkColors(
    primary = Blue700,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = Black1,
    onSecondary = Color.White,
    error = RedErrorLight,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black1,
    onSurface = Color.White,
)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    displayProgressBar: Boolean,
    scaffoldState:ScaffoldState,
    content: @Composable () -> Unit
){
    MaterialTheme (
        colors = if(darkTheme) DarkThemeColors else LightThemeColors,
        typography = KarlaTypography,
        shapes = AppShapes
    ){
        Box(
            modifier = Modifier.fillMaxSize()
            .background(color = if(!darkTheme) Grey1 else Color.Black)
        ){
            content()
            CircularIndeterminateProgressBar(isDisplayed = displayProgressBar)
            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                onDismiss = {
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                modifier = Modifier.align(
                    Alignment.BottomCenter
                )
            )
        }
    }
}
