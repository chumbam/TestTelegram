package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.isaev.drawerjetpackcompose.data.AccountData
import ru.isaev.drawerjetpackcompose.helpers.Colors
import androidx.navigation.NavHostController
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.helpers.User
import java.util.*


@Composable
fun SettingScreen(navController: NavHostController, viewModel: SettingViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopSettingScreen()
        MainSettingsScreen(navController = navController)

    }
}

@Composable
fun TopSettingScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Colors.KotogramMainColor),
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
                    .border(width = 1.dp, color = Colors.KotogramMainColor, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = User.fullname,
                    fontSize = 16.sp,
                    style = TextStyle(
                        Color.White,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = stringResource(R.string.SettingScreen_onlineStatus_text),
                    fontSize = 10.sp,
                    style = TextStyle(Color.White),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }

}


@Composable
fun ColumnScope.MainSettingsScreen(navController: NavHostController) {
    Text(
        text = "??????????????",
        modifier = Modifier.padding(top = 16.dp, start = 16.dp).fillMaxWidth(),
        style = TextStyle(Colors.KotogramMainColor),
        fontSize = 14.sp
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
    ) {

        Text(
            text = User.phone,
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = stringResource(R.string.SettingScreen_change_text),
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
            .clickable {navController.navigate(route = NavDrawerItem.ChangeUsernameScreen.route)}

    ) {

        Text(
            text = User.username.lowercase(Locale.getDefault()),
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = stringResource(R.string.SettingScreen_change_name_text),
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
            .clickable {}

    ) {

        Text(
            text = User.bio,
            modifier = Modifier.padding(start = 16.dp, top = 10.dp),
            style = TextStyle(Color.Black)
        )

        Text(
            text = "???????????????? ?????????????? ?? ????????",
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

//@Composable
//@Preview(name = "SettingScreen")
//fun SettingsScreenPreview() {
//    SettingScreen(navController)
//}