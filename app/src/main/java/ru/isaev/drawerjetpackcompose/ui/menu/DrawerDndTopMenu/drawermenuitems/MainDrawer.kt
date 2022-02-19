package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.drawermenuitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.isaev.drawerjetpackcompose.data.Items.drawerItems
import ru.isaev.drawerjetpackcompose.data.Items.drawerItemsSecond

//deprecated
@Composable
fun MainDrawer(modifier: Modifier) {

    Column(
        modifier = modifier
    ) {
        drawerItems.forEach {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(it.icon),
                    contentDescription = "Menu items",
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .weight(1f)
                        .size(20.dp)
                )
                Text(
                    text = it.title,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(5f),
                    fontSize = 12.sp
                )
            }
        }


//            Spacer(modifier = Modifier.height(14.dp)){}
        Box(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 4.dp, bottom = 4.dp).fillMaxWidth().height(6.dp)){
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                color = Color.Gray
            )
        }

        drawerItemsSecond.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(it.icon),
                    contentDescription = "Menu items",
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .weight(1f)
                        .size(20.dp)

                )
                Text(
                    text = it.title,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(5f),
                    fontSize = 12.sp
                )
            }
        }
    }
}

