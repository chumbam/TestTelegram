package ru.isaev.drawerjetpackcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun ContactsScreen(){
    var count = remember {mutableStateOf(0)}
    Column {
        Text(text = "Contacts = ${count.value}")
        Button( onClick = {count.value += 1})
        {
            Text(text = "count++")
        }


    }
}