package com.ucb.app.detail.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ucb.app.detail.presentation.composable.DetailView
import com.ucb.app.detail.presentation.composable.RankingView
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.children
import kotlinproject.composeapp.generated.resources.imagedetail

@Composable
fun DetailScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Button( onClick = {

        }) {
            Text("$40.00")
        }
        DetailView(
            resource = Res.drawable.imagedetail
        )
        Text("Beige Dress")
        Text("Relaxed fit Beige Dress in pure linen canvas")
        RankingView()
    }
}