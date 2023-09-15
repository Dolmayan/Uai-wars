package br.com.cambuy.uai.wars.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navigation: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "xablau")
    }
}