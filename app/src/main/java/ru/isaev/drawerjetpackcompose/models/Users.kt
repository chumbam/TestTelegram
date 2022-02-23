package ru.isaev.drawerjetpackcompose.models

data class Users(
    val id: String = "",
    var username: String = "",
    var bio: String = "О себе",
    var fullname: String = "",
    var status: String = "",
    var phone: String = "",
    var photoUrl: String = ""
)