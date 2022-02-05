package ru.isaev.drawerjetpackcompose.helpers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import ru.isaev.drawerjetpackcompose.activities.MainActivity


fun showToast(message: String, context: Context){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun restartActivity( act: MainActivity){
    val intent = Intent()
    act.finish()
    act.startActivity(intent)
}
