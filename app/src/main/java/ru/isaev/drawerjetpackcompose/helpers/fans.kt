package ru.isaev.drawerjetpackcompose.helpers

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.isaev.drawerjetpackcompose.activities.MainActivity


fun AppCompatActivity.showToast(message: String){
    Toast.makeText(this.applicationContext, message, Toast.LENGTH_LONG).show()
}