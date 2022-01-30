package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.helpers.Colors


@Composable
fun mToolbar (drawerButtonClick: () -> Unit){
    TopAppBar(
        title = { Text(text = "Kotogramm") },
        navigationIcon = {
            IconButton(onClick = drawerButtonClick ){
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "TopBarMenuIcon" )
            }
        },
        actions = {

        },
        backgroundColor = Colors.topBarColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().height(58.dp)

    )

    }

