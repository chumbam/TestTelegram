package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu


import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.Navigation.Drawer
import ru.isaev.drawerjetpackcompose.Navigation.Navigation
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingsToolbar
import ru.isaev.drawerjetpackcompose.ui.screens.ChatsScreen.ChatsToolbar
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.mToolbar
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeNameScreen.ChangeNameScreenTollbar
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeUsernameScreen.ChangeUserameScreenTollbar
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel


@Composable
fun DrawerAndTopMenu(
    scaffoldState: ScaffoldState,
    drawerButtonClick: () -> Unit,
    backButtonClick: () -> Unit,
    scope: CoroutineScope,
    navController: NavHostController,
    viewModel: SettingViewModel
) {


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            when (currentRoute(navController = navController)) {
                NavDrawerItem.EnterPhoneStartScreen.route -> {}
                NavDrawerItem.EnterCodeScreen.route -> {}
                NavDrawerItem.Chats.route -> ChatsToolbar(drawerButtonClick = drawerButtonClick)
                NavDrawerItem.Settings.route -> SettingsToolbar(
                    backButtonClick = backButtonClick,
                    navController = navController
                )
                NavDrawerItem.ChangeNameScreen.route -> ChangeNameScreenTollbar(
                    viewModel = viewModel,
                    navController = navController
                )
                NavDrawerItem.ChangeUsernameScreen.route -> ChangeUserameScreenTollbar(
                    viewModel = viewModel,
                    navController = navController
                )
                else -> mToolbar(backButtonClick = backButtonClick)

            }
        },
        drawerContent = {
            if (currentRoute(navController = navController) == NavDrawerItem.Chats.route) {
                Drawer(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    navController = navController
                )
            }
        },
        drawerGesturesEnabled = currentRoute(navController = navController) == NavDrawerItem.Chats.route
    ) {
        Navigation(navController = navController, viewModel = viewModel)

    }
}


// determining the current route
@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


