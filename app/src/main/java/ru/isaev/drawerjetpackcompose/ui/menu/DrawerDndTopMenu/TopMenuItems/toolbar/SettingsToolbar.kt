package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.Colors

@Composable
fun SettingsToolbar(drawerButtonClick: () -> Unit){
    val showMenu = remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = "Kotogramm") },

        navigationIcon = {
            IconButton(onClick = drawerButtonClick ){
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "TopBarMenuIcon" )
            }
        },

        actions = {

            IconButton(onClick = {showMenu.value = !showMenu.value}){
                Icon(painter = painterResource(id = R.drawable.ic_btn_option_menu_settings), contentDescription = "")
            }

                  DropdownMenu(
                      expanded = showMenu.value,
                      onDismissRequest = {showMenu.value = false}
                  ){
                      DropdownMenuItem(onClick = {}){
                          Text(text = "ChangeName")
                      }
                      DropdownMenuItem(onClick = {}){
                          Text(text = "Exit")
                      }
                  }
        },
        backgroundColor = Colors.topBarColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.height(58.dp)

    )

}