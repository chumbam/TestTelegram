package ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.drawermenuitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.isaev.drawerjetpackcompose.data.AccountData
import ru.isaev.drawerjetpackcompose.helpers.Colors

@Composable
fun TopDrawer(modifier: androidx.compose.ui.Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .clickable (onClick = {

                })
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp, top = 4.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start

        ) {
            Image(
                painter = painterResource(AccountData.userfirst.image),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .clip(shape = CircleShape)
                    .size(66.dp)
                    .border(width = 1.dp, color = Colors.topBarColor, shape = CircleShape),
                contentDescription = "AccountImage",
                contentScale = ContentScale.Crop,

            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) { Column(modifier = Modifier.weight(1f)) {
            Text(
                text = AccountData.userfirst.name,
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(top = 6.dp)
            )
            Text(
                text = AccountData.userfirst.number.toString(),
                modifier = Modifier.padding(top = 6.dp),
                style = TextStyle(color = Color.White)
            )
        }
            Column(modifier = Modifier.weight(1f)){

            }
        }
    }
}
