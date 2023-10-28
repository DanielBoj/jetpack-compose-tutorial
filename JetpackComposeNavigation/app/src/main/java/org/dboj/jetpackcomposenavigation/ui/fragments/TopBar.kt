package org.dboj.jetpackcomposenavigation.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.dboj.jetpackcomposenavigation.R
import org.dboj.jetpackcomposenavigation.navigation.AppDestination

@Composable
fun TopBar(navController: NavController, currentScreen: AppDestination? = null) {
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text( text = currentScreen?.screenName ?: R.string.app_name.toString())
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Back")
            }
        }
    }

}