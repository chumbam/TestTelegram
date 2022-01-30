package ru.isaev.drawerjetpackcompose.data

import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.NavDrawerItem
import ru.isaev.drawerjetpackcompose.models.DataDrawerMenuItems


object Items {
    val items = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "01")


    val drawerItems = listOf<DataDrawerMenuItems>(
        DataDrawerMenuItems(
            title = "Создать группу",
            icon = R.drawable.ic_menu_create__groups,
            "1"
        ),
        DataDrawerMenuItems(
            title = "Создать секретный чат",
            icon = R.drawable.ic_menu_create_secret_chat,
            "2"
        ),
        DataDrawerMenuItems(title = "Создать канал", icon = R.drawable.ic_menu_create_channel, "3"),
        DataDrawerMenuItems(title = "Контакты", icon = R.drawable.ic_menu_contacts, "4"),
        DataDrawerMenuItems(title = "Звонки", icon = R.drawable.ic_menu_phone, "5"),
        DataDrawerMenuItems(title = "Избранное", icon = R.drawable.ic_menu_favorites, "6"),
        DataDrawerMenuItems(title = "Настройки", icon = R.drawable.ic_menu_settings, "7"),
    )

    val drawerItemsSecond = listOf<DataDrawerMenuItems>(
        DataDrawerMenuItems(title = "Пригласить Друзей", icon = R.drawable.ic_menu_invate, "8"),
        DataDrawerMenuItems(title = "Вопросы о телеграмм", icon = R.drawable.ic_menu_help, "9")
    )

    //state
    val itemDrawerMenu = listOf<NavDrawerItem>(
        NavDrawerItem.CreateGroup,
        NavDrawerItem.CreateSecretChat,
        NavDrawerItem.CreateChannel,
        NavDrawerItem.Contacts,
        NavDrawerItem.Calls,
        NavDrawerItem.Favorites,
        NavDrawerItem.Settings,
        NavDrawerItem.InviteFriend,
        NavDrawerItem.TelegramFaq
    )
}
