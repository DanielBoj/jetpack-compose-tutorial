package org.dboj.jetpackcomposenavigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OverviewScreen() {
    Scaffold(
        topBar = {
            // TODO
        },
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            OverviewScreenBodyContent()
        }
    }
}

@Composable
fun OverviewScreenBodyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jetpack Compose Navigation Simple Example")
        Button(
            onClick = {
                /*TODO*/
            }
        ) {
            Text(text = "Go to Detail Screen ->")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview() {
    OverviewScreen()
}
