package com.ucb.app.fakestore.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.fakestore.domain.model.RatingModel
import com.ucb.app.fakestore.domain.model.StoreModel
import com.ucb.app.fakestore.presentation.state.FakeStoreEffect
import com.ucb.app.fakestore.presentation.state.FakeStoreEvent
import com.ucb.app.fakestore.presentation.state.FakeStoreState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FakeStoreViewModel: ViewModel() {
    private val _state = MutableStateFlow(FakeStoreState())
    val state = _state.asStateFlow()

    private val _effect = Channel<FakeStoreEffect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: FakeStoreEvent) {
        when (event) {
            FakeStoreEvent.OnLoad -> loadStore()
            FakeStoreEvent.OnRefresh -> loadStore()
        }
    }

    private fun loadStore() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            delay(1000)

            val dummyProducts = listOf(
                StoreModel(
                    1,
                    "Fjallraven Backpack",
                    109.95,
                    "Perfect pack for everyday use.",
                    "men's clothing",
                    "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
                    RatingModel(3.9, 120)
                ),
                StoreModel(
                    2,
                    "Slim Fit T-Shirt",
                    22.3,
                    "Lightweight and breathable fabric.",
                    "men's clothing",
                    "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
                    RatingModel(4.1, 259)
                ),
                StoreModel(
                    3,
                    "Cotton Jacket",
                    55.99,
                    "Great for outdoor activities.",
                    "men's clothing",
                    "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_t.png",
                    RatingModel(4.7, 500)
                ),
                StoreModel(
                    4,
                    "Casual Slim Fit",
                    15.99,
                    "Comfortable casual wear.",
                    "men's clothing",
                    "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_t.png",
                    RatingModel(2.1, 430)
                ),
                StoreModel(
                    5,
                    "Gold Dragon Bracelet",
                    695.0,
                    "Luxury bracelet with symbolic design.",
                    "jewelery",
                    "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_t.png",
                    RatingModel(4.6, 400)
                ),
                StoreModel(
                    6,
                    "Gold Micropave",
                    168.0,
                    "Elegant gold jewelry piece.",
                    "jewelery",
                    "https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_t.png",
                    RatingModel(3.9, 70)
                ),
                StoreModel(
                    7,
                    "Diamond Ring",
                    9.99,
                    "Classic engagement ring.",
                    "jewelery",
                    "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_t.png",
                    RatingModel(3.0, 400)
                ),
                StoreModel(
                    8,
                    "Rose Gold Earrings",
                    10.99,
                    "Stylish stainless steel earrings.",
                    "jewelery",
                    "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_t.png",
                    RatingModel(1.9, 100)
                ),
                StoreModel(
                    9,
                    "WD 2TB External HDD",
                    64.0,
                    "Portable storage USB 3.0.",
                    "electronics",
                    "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_t.png",
                    RatingModel(3.3, 203)
                ),
                StoreModel(
                    10,
                    "SanDisk SSD 1TB",
                    109.0,
                    "Fast SSD for performance boost.",
                    "electronics",
                    "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_t.png",
                    RatingModel(2.9, 470)
                ),
                StoreModel(
                    11,
                    "Silicon Power 256GB SSD",
                    109.0,
                    "High speed SSD.",
                    "electronics",
                    "https://fakestoreapi.com/img/71kWymZ+c+L._AC_SX679_t.png",
                    RatingModel(4.8, 319)
                ),
                StoreModel(
                    12,
                    "WD 4TB Gaming Drive",
                    114.0,
                    "External drive for gaming.",
                    "electronics",
                    "https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_t.png",
                    RatingModel(4.8, 400)
                )
            )

            _state.update {
                it.copy(
                    isLoading = false,
                    stores = dummyProducts
                )
            }
        }
    }
}