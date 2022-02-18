package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.Auth
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem

@Composable
fun SettingsToolbar(backButtonClick: () -> Unit, navController: NavHostController){
    val showMenu = remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },

        navigationIcon = {
            IconButton(onClick = backButtonClick ){
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back" )
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
                      DropdownMenuItem(onClick = {
                          navController.navigate(NavDrawerItem.ChangeNameScreen.route)
                      }){
                          Icon(painter = painterResource(R.drawable.ic_btn_action_menu_change_name), contentDescription = "ChangeName")
                          Text(text = stringResource(R.string.setting_toolbar_dropdown_menu_item_changeName_text))
                      }
                      DropdownMenuItem(onClick = {
                          Auth.signOut()
                          navController.navigate(NavDrawerItem.EnterPhoneStartScreen.route){
                              //clean all backStack
                              popUpTo(0)
                          }

                      }){
                          Icon(painter = painterResource(R.drawable.ic_btn_action_menu_exit), contentDescription = "ExitAccount")
                          Text(text = stringResource(R.string.setting_toolbar_dropdown_menu_item_exit_text))
                      }
                  }
        },
        backgroundColor = Colors.KotogramMainColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.height(58.dp)

    )

}