package org.dboj.jetpackcomposenavigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import org.dboj.jetpackcomposenavigation.navigation.AppDestination
import org.dboj.jetpackcomposenavigation.navigation.appDestinations
import org.dboj.jetpackcomposenavigation.ui.fragments.TopBar

@Composable
fun DetailScreen(navController: NavController) {
//    val currentBackStack by navController.currentBackStackEntryAsState()
//    val currentDestination: NavDestination? = currentBackStack?.destination
//    val currentScreen: AppDestination = appDestinations.first { it.route == currentDestination?.route }

    Scaffold(
        topBar = {
            TopBar(navController, AppDestination.Detail)
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            DetailScreenBodyContent(navController)
        }
    }
}

@Composable
fun DetailScreenBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jetpack Compose Navigation Simple Example")
        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text(text = "Go back ->")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(navController = NavController(LocalContext.current))
}
