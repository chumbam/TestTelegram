package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.R

@Composable
fun SettingsToolbar(){
    val showMenu = remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = "Kotogramm") },

        actions = {

            IconButton(onClick = {showMenu.value = !showMenu.value}){
                Icon(painter = painterResource(id = R.drawable.ic_btn_option_menu_settings), contentDescription = "")
            }

                  DropdownMenu(
                      expanded = showMenu.value,
                      onDismissRequest = {showMenu.value = false}
                  ){
                      DropdownMenuItem(onClick = {}){
                          Text(text = "changeName")
                      }
                      DropdownMenuItem(onClick = {}){
                          Text(text = "Exit")
                      }
                  }
        },
        backgroundColor = Color.Black,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.height(58.dp)

    )

}