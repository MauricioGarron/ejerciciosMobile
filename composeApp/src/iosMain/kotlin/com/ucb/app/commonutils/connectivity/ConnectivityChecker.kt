package com.ucb.app.commonutils.connectivity

actual class ConnectivityChecker actual constructor() {
    actual fun isConnected(): Boolean {
        // For iOS, assume connected or implement proper check
        return true
    }
}