package com.ucb.app.detail.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.icon_cart
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailView(
    resource: DrawableResource
) {
    Box(
        modifier = Modifier.
            size(326.dp, 505.dp)
                .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painterResource(resource),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop

        )
        IconButton(
            modifier = Modifier.align(
                Alignment.BottomEnd
            ),
            onClick = {

            }
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(Res.drawable.icon_cart),
                contentDescription = null
            )
        }
    }

}