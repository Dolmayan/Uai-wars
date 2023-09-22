package br.com.cambuy.uai.wars.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.cambuy.uai.characters.presentation.CharactersScreen
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.CHARACTERS_DETAIL_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.CHARACTERS_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.COMICS_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.SETTINGS_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.SPLASH_SCREEN
import br.com.cambuy.uai.design_system.theme.UaiWarsTheme
import br.com.cambuy.uai.wars.splash.SplashScreen
import br.com.cambuy.uai.wars.ui.navigationBar.UaiWarsNavBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UaiWarsTheme {
                val systemUiController = rememberSystemUiController()
                val backgroundColor = MaterialTheme.colorScheme.background
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                LaunchedEffect(systemUiController) {
                    systemUiController.setSystemBarsColor(backgroundColor)
                }

                UaiWarsNavBar(
                    currentDestination = currentDestination,
                    navController = navController,
                    content = { UaiWarsNavHost(navController) }
                )
            }
        }
    }

    @Composable
    fun UaiWarsNavHost(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = CHARACTERS_SCREEN,
        ) {
            screens(navController)
        }
    }

    private fun NavGraphBuilder.screens(navController: NavHostController) {
        composable(route = SPLASH_SCREEN) {
            SplashScreen(navigation = navController)
        }
        composable(route = CHARACTERS_SCREEN) {
            CharactersScreen(navigation = navController)
        }
        composable(route = CHARACTERS_DETAIL_SCREEN) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {

            }
        }
        composable(route = COMICS_SCREEN) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Green)
            ) {

            }
        }
        composable(route = SETTINGS_SCREEN) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Red)
            ) {

            }
        }
    }
}