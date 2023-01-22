package com.example.a30days.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30days.R

val Courgette = FontFamily(
    Font(resId = R.font.courgette_regular, style = FontStyle.Normal)
)

val Crimson = FontFamily(
    Font(resId = R.font.crimson_text_italic, style = FontStyle.Italic),
    Font(resId = R.font.crimson_text_bold, weight = FontWeight.Bold),
    Font(resId = R.font.crimson_text_regular, weight = FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Courgette,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = Crimson,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = Crimson,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Crimson,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)