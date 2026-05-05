package com.ucb.app.movie.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.ucb.app.movie.presentation.composable.CardMovie
import com.ucb.app.movie.presentation.viewmodel.MovieViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsState()
    if(state.value.isLoading) {
        CircularProgressIndicator()
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.value.list.size) {
                CardMovie( state.value.list[it])
            }
        }
    }
}