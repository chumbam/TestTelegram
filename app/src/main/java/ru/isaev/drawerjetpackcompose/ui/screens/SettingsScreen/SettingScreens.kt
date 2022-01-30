package ru.isaev.drawerjetpackcompose.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.isaev.drawerjetpackcompose.data.AccountData
import ru.isaev.drawerjetpackcompose.helpers.Colors
import androidx.compose.runtime.remember
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.TopMenuItems.toolbar.SettingsToolbar


@Composable
fun SettingScreen() {

   SettingsToolbar()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopSettingScreen()
        MainSettingsScreen()

    }
}

@Composable
fun TopSettingScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Colors.topBarColor),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(AccountData.userfirst.image),
                contentDescription = "UserImage",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(55.dp)
                    .align(Alignment.CenterVertically)
                    .clip(shape = CircleShape)
                    .border(width = 1.dp, color = Colors.topBarColor, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = AccountData.userfirst.name,
                    fontSize = 16.sp,
                    style = TextStyle(
                        Color.White,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "В сети",
                    fontSize = 10.sp,
                    style = TextStyle(Color.White),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }

}


@Composable
fun ColumnScope.MainSettingsScreen() {
    Text(
        text = "Аккаунт",
        modifier = Modifier.padding(top = 16.dp, start = 16.dp).fillMaxWidth(),
        style = TextStyle(Colors.topBarColor),
        fontSize = 14.sp
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{}
    ) {

        Text(
            text = "+79991111111",
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = "Нажмите, чтобы изменить номер телефона",
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(
                Colors.descriptionTextColor,
                fontSize = 10.sp
            )
        )

        Divider(
            color = Colors.descriptionTextColor,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 16.dp)
        )

    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{}

    ) {

        Text(
            text = "IvanIvanov",
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = "Имя пользователя",
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(
                Colors.descriptionTextColor,
                fontSize = 10.sp
            )
        )

        Divider(
            color = Colors.descriptionTextColor,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 16.dp)
        )

    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{}

    ) {

        Text(
            text = "О себе",
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = "Напишите немного о себе",
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(
                Colors.descriptionTextColor,
                fontSize = 10.sp
            )
        )

        Divider(
            color = Colors.descriptionTextColor,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp, start = 16.dp, end = 16.dp)
        )

    }
}

@Composable
@Preview(name = "SettingScreen")
fun SettingsScreenPreview() {
    SettingScreen()
}