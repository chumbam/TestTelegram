package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeUsernameScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel

@Composable
fun ChangeUsernameScreen(viewModel: SettingViewModel) {


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = viewModel.username.value,
            onValueChange = {
                viewModel._username.value = it
            },
            placeholder = { Text(text = stringResource(R.string.ChangenameScreen_placeholder_text)) },

            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f).padding(top = 16.dp, bottom = 16.dp)
        )

    }
}
