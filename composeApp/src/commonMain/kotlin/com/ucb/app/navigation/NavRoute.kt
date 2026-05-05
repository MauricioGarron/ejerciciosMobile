package com.ucb.app.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute(val route: String) {
    @Serializable
    object Crypto : NavRoute("crypto")

    @Serializable
    object AddCrypto : NavRoute("crypto_add")
}
