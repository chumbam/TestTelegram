package ru.isaev.drawerjetpackcompose.other

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
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
            NewGroupScreen()
        }
        composable(route = NavDrawerItem.CreateSecretChat.route) {
            NewSecretChatScreen()
        }
        composable(route = NavDrawerItem.CreateChannel.route) {
            NewChannelScreen()
        }
        composable(route = NavDrawerItem.Contacts.route) {
            ContactsScreen()
        }
        composable(route = NavDrawerItem.Calls.route) {
            CallsScreen()
        }
        composable(route = NavDrawerItem.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = NavDrawerItem.Settings.route) {
            SettingScreen()
        }
        composable(route = NavDrawerItem.InviteFriend.route) {
            InviteFriendScreen()
        }
        composable(route = NavDrawerItem.TelegramFaq.route) {
            TelegramFaqScreen()
        }


    }
}