package com.example.mvvmrecipecomposeapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mvvmrecipecomposeapp.R

private val Karla = FontFamily(
    Font(R.font.karla_light, FontWeight.W300),
    Font(R.font.karla_regular, FontWeight.W400),
    Font(R.font.karla_medium, FontWeight.W500),
    Font(R.font.karla_bold, FontWeight.W600)
)

val KarlaTypography = Typography(
    h1 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Karla,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Karla,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )

)