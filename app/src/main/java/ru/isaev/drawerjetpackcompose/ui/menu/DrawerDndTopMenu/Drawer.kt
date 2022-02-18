package ru.isaev.drawerjetpackcompose.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.data.Items
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.drawermenuitems.TopDrawer

@Composable
fun ColumnScope.Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    val itemDrawerMenu = Items.itemDrawerMenu

    TopDrawer(
        modifier = Modifier
            .weight(1f)
            .background(color = Colors.KotogramMainColor)
            .fillMaxWidth()
    )

    Column(
        modifier = Modifier
            .weight(2f)
            .fillMaxWidth()
    ) {
        itemDrawerMenu.forEach { item ->
            DrawerMainItem(item = item, modifier = Modifier
                .weight(1f)
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(8.dp),
                onItemClick = {

                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(it) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
    }

}