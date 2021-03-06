package ru.isaev.drawerjetpackcompose.ui.screens.ChatsScreen
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.R


@Composable
fun ChatsToolbar (drawerButtonClick: () -> Unit){
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = drawerButtonClick ){
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "TopBarMenuIcon" )
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

