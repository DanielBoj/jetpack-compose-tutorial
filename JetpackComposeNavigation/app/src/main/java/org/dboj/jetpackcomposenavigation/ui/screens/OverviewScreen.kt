package org.dboj.jetpackcomposenavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import org.dboj.jetpackcomposenavigation.R
import org.dboj.jetpackcomposenavigation.navigation.AppDestination
import org.dboj.jetpackcomposenavigation.navigation.navigateSingleTopTo

@Composable
fun OverviewScreen(navController: NavController) {
//    val currentBackStack by navController.currentBackStackEntryAsState()
//    val currentDestination: NavDestination? = currentBackStack?.destination

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = R.string.app_name.toString())
            }
        },
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            OverviewScreenBodyContent(navController)
        }
    }
}

@Composable
fun OverviewScreenBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jetpack Compose Navigation Simple Example")
        Button(
            onClick = { navController.navigateSingleTopTo(
                route = AppDestination.Detail.route +
                        "/Soy un texto enviado como parámetro!")
            }
        ) {
            Text(text = "Go to Detail Screen ->")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview() {
    OverviewScreen(navController = NavController(LocalContext.current))
}
