package ru.isaev.drawerjetpackcompose.helpers

import ru.isaev.drawerjetpackcompose.R

sealed class NavDrawerItem(val title: String, val icon: Int, val route: String) {

    object Chats : NavDrawerItem(title = "Чаты", icon = 1, route = "Chats")

    object CreateGroup : NavDrawerItem(
        title = "Создать группу",
        icon = R.drawable.ic_menu_create__groups,
        "CreateGroup"
    )

    object CreateSecretChat : NavDrawerItem(
        title = "Создать секретный чат",
        icon = R.drawable.ic_menu_create_secret_chat,
        "CreateSecretChat"
    )

    object CreateChannel : NavDrawerItem(
        title = "Создать канал",
        icon = R.drawable.ic_menu_create_channel,
        "CreateChannel"
    )

    object Contacts :
        NavDrawerItem(title = "Контакты", icon = R.drawable.ic_menu_contacts, "Contacts")

    object Calls : NavDrawerItem(title = "Звонки", icon = R.drawable.ic_menu_phone, "Calls")

    object Favorites :
        NavDrawerItem(title = "Избранное", icon = R.drawable.ic_menu_favorites, "Favorites")

    object Settings :
        NavDrawerItem(title = "Настройки", icon = R.drawable.ic_menu_settings, "Settings")

    object InviteFriend :
        NavDrawerItem(title = "Пригласить Друзей", icon = R.drawable.ic_menu_invate, "InviteFriend")

    object TelegramFaq :
        NavDrawerItem(title = "Вопросы о телеграмм", icon = R.drawable.ic_menu_help, "FaqTelegram")

    // Temp
    object EnterPhoneStartScreen : NavDrawerItem(title = "", icon = 1, route = "EnterPhone")
    object EnterCodeScreen : NavDrawerItem(title = "", icon = 1, route = "EnterPhoneCode")

}
