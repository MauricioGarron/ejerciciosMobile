package com.ucb.app.product_detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailViewModel: ViewModel() {
    private val _cadena = MutableStateFlow("0")
    val cadena: StateFlow<String> = _cadena.asStateFlow()
    fun increment() {
        _cadena.value = ((_cadena.value?.toIntOrNull() ?:0) + 1).toString()
    }
}

