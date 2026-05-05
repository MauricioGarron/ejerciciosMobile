package com.ucb.app.crypto.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ucb.app.crypto.domain.model.CryptoModel

@Composable
fun CryptoContent(cryptos: List<CryptoModel>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(cryptos.size) {
            CryptoCard(cryptos[it])
        }

    }
}