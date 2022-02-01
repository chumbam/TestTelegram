package ru.isaev.drawerjetpackcompose.other

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.isaev.drawerjetpackcompose.helpers.Auth
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.ui.screens.*
import ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen.EnterCodeScreen
import ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen.EnterPhoneNumberScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = if (Auth.currentUser != null) {
            NavDrawerItem.CreateChannel.route
        } else NavDrawerItem.EnterPhoneStartScreen.route
    ) {

        composable(route = NavDrawerItem.EnterCodeScreen.route) {
            EnterCodeScreen(navController)
        }

        composable(route = NavDrawerItem.EnterPhoneStartScreen.route) {
            EnterPhoneNumberScreen(navController)
        }

        composable(route = NavDrawerItem.CreateGroup.route) {
            NewGroupScreen(navController)
        }
        composable(route = NavDrawerItem.CreateSecretChat.route) {
            NewSecretChatScreen(navController)
        }
        composable(route = NavDrawerItem.CreateChannel.route) {
            NewChannelScreen(navController)
        }
        composable(route = NavDrawerItem.Contacts.route) {
            ContactsScreen(navController)
        }
        composable(route = NavDrawerItem.Calls.route) {
            CallsScreen(navController)
        }
        composable(route = NavDrawerItem.Favorites.route) {
            FavoritesScreen(navController)
        }
        composable(route = NavDrawerItem.Settings.route) {
            SettingScreen(navController)
        }
        composable(route = NavDrawerItem.InviteFriend.route) {
            InviteFriendScreen(navController)
        }
        composable(route = NavDrawerItem.TelegramFaq.route) {
            TelegramFaqScreen(navController)
        }


    }
}