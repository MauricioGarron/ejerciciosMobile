package com.ucb.app.github.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ucb.app.github.presentation.state.GithubEvent
import com.ucb.app.github.presentation.viewmodel.GithubViewModel
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.github_find
import kotlinproject.composeapp.generated.resources.github_text_hint
import kotlinproject.composeapp.generated.resources.github_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GithubScreen( viewModel: GithubViewModel = koinViewModel()) {

    val state by viewModel.state.collectAsState()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState).padding(vertical = 40.dp, horizontal = 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(Res.string.github_title),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold)
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = {
                    Text(stringResource(Res.string.github_text_hint))
                },
                value = state.nickname, onValueChange = {
                viewModel.onEvent(GithubEvent.OnChangeAvatar(it))
            })
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isLoading,
                onClick = {
                    viewModel.onEvent(GithubEvent.OnClickFind)
                }) {
                Text(stringResource(Res.string.github_find))
            }
            HorizontalDivider(modifier = Modifier.height(1.dp))

        }

        Spacer(modifier = Modifier.height(24.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column( modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)) {
                with(MaterialTheme) {
                    AsyncImage(model = state.model.urlImage, contentDescription = null)
                    Text(state.model.avatar,
                        style = typography.titleMedium)
                    Text(state.model.urlImage,
                        style = typography.labelSmall)
                    Text(state.model.company,
                        style = typography.bodyMedium)
                    Text(state.model.bio,
                        style = typography.bodySmall,
                        color = colorScheme.onSurfaceVariant)
                }

            }
        }
    }
}