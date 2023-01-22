package com.example.a30days.data

import com.example.a30days.R
import com.example.a30days.model.AppQuote

class DataResources {
    val quotes = listOf<AppQuote>(
        AppQuote(
            title = R.string.title1,
            description = R.string.description1,
            image = R.drawable.image1
        ),
        AppQuote(
            title = R.string.title1,
            description = R.string.description1,
            image = R.drawable.image1
        ),
    )
}