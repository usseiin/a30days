package com.example.a30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AppQuote(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
