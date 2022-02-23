package ru.isaev.drawerjetpackcompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.isaev.drawerjetpackcompose.helpers.Auth
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.ui.screens.CallsScreen.CallsScreen
import ru.isaev.drawerjetpackcompose.ui.screens.ChatsScreen.ChatsScreen
import ru.isaev.drawerjetpackcompose.ui.screens.ContactsScreen.ContactsScreen
import ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen.EnterCodeScreen
import ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen.EnterPhoneNumberScreen
import ru.isaev.drawerjetpackcompose.ui.screens.FavoritesScreen.FavoritesScreen
import ru.isaev.drawerjetpackcompose.ui.screens.InviteFriendScreen.InviteFriendScreen
import ru.isaev.drawerjetpackcompose.ui.screens.NewChannelScreen.NewChannelScreen
import ru.isaev.drawerjetpackcompose.ui.screens.NewGroupScreen.NewGroupScreen
import ru.isaev.drawerjetpackcompose.ui.screens.NewSecretChatScreen.NewSecretChatScreen
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeNameScreen.ChangeNameScreen
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeUsernameScreen.ChangeUsernameScreen
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingScreen
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel
import ru.isaev.drawerjetpackcompose.ui.screens.TelegramFaqScreen.TelegramFaqScreen


@Composable
fun Navigation(navController: NavHostController, viewModel: SettingViewModel) {
    NavHost(
        navController = navController, startDestination = if (Auth.currentUser != null) {
            NavDrawerItem.Chats.route
        } else NavDrawerItem.EnterPhoneStartScreen.route
    ) {

        composable(route = NavDrawerItem.Chats.route) {
            ChatsScreen()
        }

        composable(route = NavDrawerItem.EnterCodeScreen.route) {
            EnterCodeScreen(navController = navController)
        }

        composable(route = NavDrawerItem.EnterPhoneStartScreen.route) {
            EnterPhoneNumberScreen(navController = navController)
        }

        composable(route = NavDrawerItem.CreateGroup.route) {
            NewGroupScreen(navController = navController)
        }
        composable(route = NavDrawerItem.CreateSecretChat.route) {
            NewSecretChatScreen(navController = navController)
        }
        composable(route = NavDrawerItem.CreateChannel.route) {
            NewChannelScreen(navController = navController)
        }
        composable(route = NavDrawerItem.Contacts.route) {
            ContactsScreen(navController = navController)
        }
        composable(route = NavDrawerItem.Calls.route) {
            CallsScreen(navController = navController)
        }
        composable(route = NavDrawerItem.Favorites.route) {
            FavoritesScreen(navController = navController)
        }
        composable(route = NavDrawerItem.Settings.route) {
            SettingScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = NavDrawerItem.InviteFriend.route) {
            InviteFriendScreen(navController = navController)
        }
        composable(route = NavDrawerItem.TelegramFaq.route) {
            TelegramFaqScreen(navController = navController)
        }
        composable(route = NavDrawerItem.ChangeNameScreen.route) {
            ChangeNameScreen(viewModel)
        }
        composable(route = NavDrawerItem.ChangeUsernameScreen.route) {
            ChangeUsernameScreen(viewModel = viewModel)
        }


    }
}