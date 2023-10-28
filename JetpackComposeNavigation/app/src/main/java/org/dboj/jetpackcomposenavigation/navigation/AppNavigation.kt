package org.dboj.jetpackcomposenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.dboj.jetpackcomposenavigation.ui.screens.DetailScreen
import org.dboj.jetpackcomposenavigation.ui.screens.OverviewScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Overview.route + "/{text}",
        navArgument(name = "text") { StringType }
    ) {
        composable(AppDestination.Overview.route) { OverviewScreen(navController) }
        composable(AppDestination.Detail.route) { DetailScreen(navController) }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) {
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            inclusive = true
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}