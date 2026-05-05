package com.ucb.app.product_detail.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ucb.app.product_detail.presentation.viewmodel.ProductDetailViewModel
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.icon_cart
import kotlinproject.composeapp.generated.resources.imagedetail
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductDetailScreen(modifier: Modifier, viewModel: ProductDetailViewModel = koinViewModel()) {

    val cadenaState = viewModel.cadena.collectAsState()

    val scroll = rememberScrollState()
    Box( modifier = Modifier.background(Color.Red).fillMaxSize().padding(25.dp)
        .verticalScroll(scroll)) {
        Box( modifier = Modifier.align(Alignment.TopCenter)) {
            Image(
                modifier = Modifier.size(326.dp, 505.dp),
                painter = painterResource(Res.drawable.imagedetail),
                contentDescription = null
            )
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(cadenaState.value)
                IconButton(onClick = {
                    viewModel.increment()
                }) {
                    Text("S")
                }
                IconButton(onClick = {
                }) {
                    Text("M")
                }
                IconButton(onClick = {
                }) {
                    Text("L")
                }
                IconButton(onClick = {
                }) {
                    Text("XL")
                }
            }
            Card(
                modifier = Modifier.size(292.dp, 279.dp)
                .align(Alignment.BottomCenter).offset(y = 190.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEAEAEA)
                )) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.
                            fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Price Tag",
                            modifier = Modifier.weight(1f),
                            fontSize = 16.sp)
                        Text("$40.00",
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Button( onClick = {

                    }) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally)
                        ) {
                            Text("Add to cart")
                            Icon(
                                modifier = Modifier.size(22.dp),
                                painter = painterResource(Res.drawable.icon_cart),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                    }
                }
            }
        }

    }
}