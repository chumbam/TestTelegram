package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.helpers.showToast


@Composable
fun ChangeNameScreenTollbar(viewModel: SettingViewModel, navController: NavHostController) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },

        actions = {

            IconButton(onClick = {
                if (viewModel.name.value.isEmpty()) showToast(
                    message = "Имя не может быть пустым",
                    context = context
                )
                else {
                    viewModel.fullname = "${viewModel.name.value} ${viewModel.surname.value}"
                    viewModel.changeFullName()
                    navController.navigateUp()
                }
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "")
            }
        },
        backgroundColor = Colors.KotogramMainColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.height(58.dp)

    )
}