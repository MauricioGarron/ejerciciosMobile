package com.ucb.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform