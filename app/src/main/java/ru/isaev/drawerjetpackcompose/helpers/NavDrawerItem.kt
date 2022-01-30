package ru.isaev.drawerjetpackcompose.helpers

import ru.isaev.drawerjetpackcompose.R

sealed class NavDrawerItem(val title: String, val icon: Int, val route: String){
 object CreateGroup: NavDrawerItem(title = "Создать группу", icon= R.drawable.ic_menu_create__groups, "1")
    object CreateSecretChat: NavDrawerItem(title = "Создать секретный чат", icon=R.drawable.ic_menu_create_secret_chat, "2")
    object CreateChannel: NavDrawerItem(title = "Создать канал", icon=R.drawable.ic_menu_create_channel,"3")
    object Contacts: NavDrawerItem(title = "Контакты", icon=R.drawable.ic_menu_contacts, "4")
    object Calls: NavDrawerItem(title = "Звонки", icon=R.drawable.ic_menu_phone, "5")

    object Favorites: NavDrawerItem(title = "Избранное", icon=R.drawable.ic_menu_favorites,"6")
    object Settings: NavDrawerItem(title = "Настройки", icon=R.drawable.ic_menu_settings,"7")
    object InviteFriend: NavDrawerItem(title = "Пригласить Друзей", icon=R.drawable.ic_menu_invate,"8")
    object TelegramFaq: NavDrawerItem(title = "Вопросы о телеграмм", icon=R.drawable.ic_menu_help,"9")
   // Temp
    object EnterPhoneStartScreen: NavDrawerItem (title = "", icon = 1, route = "10")
    object EnterCodeScreen: NavDrawerItem (title = "", icon = 1, route = "11")
}
