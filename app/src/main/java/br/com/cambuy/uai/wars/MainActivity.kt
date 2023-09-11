package br.com.cambuy.uai.wars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.cambuy.uai.wars.characters.CharactersScreen
import br.com.cambuy.uai.wars.splash.SplashScreen
import br.com.cambuy.uai.wars.ui.theme.UaiWarsTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UaiWarsTheme {
                val systemUiController = rememberSystemUiController()
                val backgroundColor = MaterialTheme.colorScheme.background
                val navController = rememberAnimatedNavController()

                LaunchedEffect(systemUiController) {
                    systemUiController.setSystemBarsColor(backgroundColor)
                }
                MonthlyPlanningNavHost(navController)
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun MonthlyPlanningNavHost(navController: NavHostController) {
        AnimatedNavHost(
            navController = navController,
            startDestination = SPLASH_SCREEN,
            enterTransition = {
                slideInHorizontally(
                    animationSpec = tween(ANIMATION_DURATION),
                    initialOffsetX = { it / 2 }
                )
            },
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(ANIMATION_DURATION))
            }
        ) {
            screens(navController)
        }
    }

    private fun NavGraphBuilder.screens(navController: NavHostController) {
        composable(route = SPLASH_SCREEN) {
            CharactersScreen(navigation = navController)
        }
        composable(route = CHARACTERS_SCREEN) {
            SplashScreen(navigation = navController)
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 300
        const val SPLASH_SCREEN = "splash_screen"
        const val CHARACTERS_SCREEN = "characters_screen"
        const val CHARACTERS_DETAIL_SCREEN = "characters_detail_screen"
        const val BACK_PRESSED = "back_press"

        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}