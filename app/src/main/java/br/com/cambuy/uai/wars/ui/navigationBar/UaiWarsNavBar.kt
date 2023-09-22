package br.com.cambuy.uai.wars.ui.navigationBar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController

@Composable
fun UaiWarsNavBar(
    currentDestination: NavDestination?,
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {

    val itemsList = listOf(
        BottomNavigationItem.Characters,
        BottomNavigationItem.Comics,
        BottomNavigationItem.Settings
    )

    Scaffold(bottomBar = {
        NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
            itemsList.forEach { item ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == item.route
                    } == true,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    }
                )
            }
        }
    }) {
        content(it)
    }
}