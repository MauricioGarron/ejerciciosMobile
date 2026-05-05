package com.ucb.app.fakestore.presentation.state

import com.ucb.app.fakestore.domain.model.StoreModel

data class FakeStoreState(val isLoading: Boolean = false,
                          val stores: List<StoreModel> = emptyList(),
                          val error: String? = null
)