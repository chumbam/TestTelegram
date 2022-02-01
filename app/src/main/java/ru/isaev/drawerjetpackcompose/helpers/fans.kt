package ru.isaev.drawerjetpackcompose.helpers

import android.content.Context
import android.widget.Toast



fun showToast(message: String, context: Context){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

