package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu


import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.other.Drawer
import ru.isaev.drawerjetpackcompose.other.Navigation
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.SettingsToolbar
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.ChatsToolbar
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.mToolbar


@Composable
fun DrawerAndTopMenu(
    scaffoldState: ScaffoldState,
    drawerButtonClick: () -> Unit,
    backButtonClick: () -> Unit,
    scope: CoroutineScope,
    navController: NavHostController
) {


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            when (currentRoute(navController = navController)) {
                NavDrawerItem.EnterPhoneStartScreen.route -> {}
                NavDrawerItem.EnterCodeScreen.route -> {}
                NavDrawerItem.Chats.route -> ChatsToolbar (drawerButtonClick = drawerButtonClick)
                NavDrawerItem.Settings.route -> SettingsToolbar(drawerButtonClick = drawerButtonClick, navController = navController)
                else -> mToolbar(backButtonClick = backButtonClick )

            }
        },

        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)

    }
}




// determining the current route
@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


