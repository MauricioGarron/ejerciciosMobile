package com.ucb.app.detail.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.vd_vector
import org.jetbrains.compose.resources.painterResource

@Composable
fun RankingView(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text("5.0")
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(Res.drawable.vd_vector),
            contentDescription = null,
            tint = Color.Yellow
        )
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(Res.drawable.vd_vector),
            contentDescription = null
        )
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(Res.drawable.vd_vector),
            contentDescription = null
        )
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(Res.drawable.vd_vector),
            contentDescription = null
        )
        Icon(
            modifier = Modifier.size(15.dp),
            painter = painterResource(Res.drawable.vd_vector),
            contentDescription = null
        )
    }

}