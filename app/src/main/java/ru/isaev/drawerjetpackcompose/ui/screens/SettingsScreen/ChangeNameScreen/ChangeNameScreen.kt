package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeNameScreen

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel

@Composable
fun ChangeNameScreen(viewModel: SettingViewModel) {


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = viewModel.name.value,
            onValueChange = {
                viewModel._name.value = it
            },
            placeholder = { Text(text = "Name") },

            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f).padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = viewModel.surname.value,
            onValueChange = {
                viewModel._surname.value = it
            },
            placeholder = { Text(text = "Surname") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f).padding(top = 16.dp, bottom = 16.dp)
        )
    }
}
