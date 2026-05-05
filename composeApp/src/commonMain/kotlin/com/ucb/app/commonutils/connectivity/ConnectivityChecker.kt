package com.ucb.app.commonutils.connectivity

expect class ConnectivityChecker() {
    fun isConnected(): Boolean
}