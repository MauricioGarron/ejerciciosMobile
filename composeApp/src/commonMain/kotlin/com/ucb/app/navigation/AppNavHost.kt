package com.ucb.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.app.country.presentation.screen.CountryScreen
import com.ucb.app.crypto.presentation.screen.AddCryptoScreen
import com.ucb.app.crypto.presentation.screen.CryptoScreen
import com.ucb.app.fakestore.presentation.screen.StoreScreen
import com.ucb.app.github.presentation.screen.GithubScreen
import com.ucb.app.movie.presentation.screen.MovieScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Crypto) {
        composable<NavRoute.Crypto> {
            CryptoScreen(navController)
        }
        composable<NavRoute.AddCrypto> {
            AddCryptoScreen(navController)
        }
    }
}
