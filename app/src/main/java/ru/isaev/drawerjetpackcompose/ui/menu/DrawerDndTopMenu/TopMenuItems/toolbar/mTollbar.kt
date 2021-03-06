package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.Colors


@Composable
fun mToolbar(backButtonClick: () -> Unit){
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = backButtonClick ){
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back" )
            }
        },
        actions = {

        },
        backgroundColor = Colors.KotogramMainColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().height(58.dp)

    )

}