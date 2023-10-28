package org.dboj.jetpackcomposenavigation.navigation

import org.dboj.jetpackcomposenavigation.R

interface IAppDestination {
    val route: String
    val screenName: String
}

sealed class AppDestination(
    override val route: String,
    override val screenName: String
): IAppDestination {
    data object Overview : AppDestination("overview_screen", R.string.app_name.toString())
    data object Detail : AppDestination("detail_screen", "Detail")
}

val appDestinations = listOf(
    AppDestination.Overview,
    AppDestination.Detail
)