package com.ucb.app.signin.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ucb.app.signin.presentation.state.SigninEvent
import com.ucb.app.signin.presentation.viewmodel.SigninViewModel
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.sign_in_btn
import kotlinproject.composeapp.generated.resources.sign_in_email
import kotlinproject.composeapp.generated.resources.sign_in_password
import kotlinproject.composeapp.generated.resources.sign_in_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SigninScreen(viewModel: SigninViewModel = koinViewModel()) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("")}
    Column {
        Text(stringResource(Res.string.sign_in_title))
        TextField(
            onValueChange = {
                email = it
                viewModel.onEvent(SigninEvent.OnEmailChanged(it))
            },
            value = email,
            label = {
                Text(stringResource(Res.string.sign_in_email))
            }
        )
        TextField(
            onValueChange = {
                password = it
                viewModel.onEvent(SigninEvent.OnPasswordChanged(it))
            },
            value = password,
            label = {
                Text(stringResource(Res.string.sign_in_password))
            }
        )
        Button(
            onClick = {
                viewModel.onEvent(SigninEvent.OnClick)
            }
        ) {
            Text(stringResource(Res.string.sign_in_btn))
        }
    }
}