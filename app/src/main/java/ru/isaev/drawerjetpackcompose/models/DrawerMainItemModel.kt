package ru.isaev.drawerjetpackcompose.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem

@Composable
fun DrawerMainItem(item: NavDrawerItem, onItemClick: (NavDrawerItem) -> Unit, modifier: Modifier) {

    Column(
        modifier = modifier

    ) {
        Row(
            modifier = Modifier
                .clickable { onItemClick(item) }
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(item.icon),
                contentDescription = item.title,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .weight(1f)
                    .size(20.dp),
                colorFilter = ColorFilter.tint(color = Colors.drawerIconsColor)
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(5f),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
