package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu


import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.other.Drawer
import ru.isaev.drawerjetpackcompose.other.Navigation
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.mToolbar


@Composable
fun DrawerAndTopMenu(
    scaffoldState: ScaffoldState,
    drawerButtonClick: () -> Unit,
    scope: CoroutineScope,
    navController: NavHostController,
    isAuth: MutableState<Boolean>,
    context: Context,
    mAuth:FirebaseAuth
) {


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if (currentRoute(navController = navController) != "10"   ) {
                mToolbar(drawerButtonClick = drawerButtonClick)
            }
            else if (currentRoute(navController = navController) != "11"){
                mToolbar(drawerButtonClick = drawerButtonClick)
        }
        },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController, isAuth = isAuth, context = context, mAuth = mAuth)

    }
}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


