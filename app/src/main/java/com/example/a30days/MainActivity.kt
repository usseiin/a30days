package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.data.DataResources
import com.example.a30days.model.AppQuote
import com.example.a30days.ui.theme.A30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A30DaysTheme {
                A30DaysApp(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun A30DaysApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            AppTopBar(modifier = Modifier)
        }
    ) {
        A30DaysList(quotes = DataResources().quotes)
    }

}

@Composable
fun AppTopBar(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun A30DaysList(quotes: List<AppQuote>) {
    LazyColumn {
        items(quotes.size) {
            index -> A30DaysItem(quote = quotes[index], index = index+1)
        }
    }
}

@Composable
fun A30DaysItem(
    index: Int,
    quote: AppQuote,
    modifier: Modifier = Modifier
) {
    var expand by remember { mutableStateOf(false) }
    Card(
        elevation = 2.dp,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text(
                stringResource(R.string.day)+" "+index.toString(),
                style = MaterialTheme.typography.h2
            )
            Spacer(Modifier.height(2.dp))
            QuoteTitle(quote.title)
            Spacer(Modifier.height(4.dp))
            QuoteImage(quote.image) { expand = !expand }
            if(expand)
            QuoteDescription(quote.description)
        }
    }

}

@Composable
fun QuoteDescription(@StringRes description: Int) {
    Box(Modifier.padding(top = 10.dp)) {
        Text(
            stringResource(description),
            style = MaterialTheme.typography.body1
        )
    }

}

@Composable
fun QuoteImage(@DrawableRes image: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun QuoteTitle(@StringRes title: Int) {
    Text(
        stringResource(title),
        style = MaterialTheme.typography.h3
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    A30DaysTheme {
        A30DaysApp(
//            modifier = Modifier
//                .fillMaxSize()
//                .wrapContentSize()
        )
    }
}