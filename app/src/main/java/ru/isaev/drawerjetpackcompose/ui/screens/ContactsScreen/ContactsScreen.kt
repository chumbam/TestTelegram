package ru.isaev.drawerjetpackcompose.ui.screens.ContactsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController

@Composable
fun ContactsScreen(navController: NavHostController) {
    var count = remember {mutableStateOf(0)}
    Column {
        Text(text = "Contacts = ${count.value}")
        Button( onClick = {count.value += 1})
        {
            Text(text = "count++")
        }


    }
}