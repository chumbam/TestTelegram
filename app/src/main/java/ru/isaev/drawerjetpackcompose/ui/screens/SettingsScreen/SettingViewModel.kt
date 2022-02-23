package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.*
import java.util.*

class SettingViewModel(application: Application) : AndroidViewModel(application) {

    //this is an alternative to remember{mutableStateOf} which is used only in composable functions. This method is used in view Models
    //Change Name Screen
    var _name = mutableStateOf("")
    var name: State<String> = _name
    var _surname = mutableStateOf("")
    var surname: State<String> = _surname
    var fullname = ""

    //Change Username Screen
    var _username = mutableStateOf("")
    var username: State<String> = _username
    var mUsername = ""


    //This is a way to get the application context in ViewModels
    @SuppressLint("StaticFieldLeak")
    val context: Context = getApplication<Application>().applicationContext

    fun changeFullName() {
        viewModelScope.launch {
            Ref_Database_Root.child(NODE_USER).child(Uid).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(message = "Данные обновлены", context = context)
                        User.fullname = fullname
                    }

                }
        }
    }

    //Create new Node in FB where will we check if the nickname is busy
    fun changeUsername() {
        viewModelScope.launch {
            Ref_Database_Root.child(NODE_USERNAME)
                .child(mUsername.lowercase(Locale.getDefault()))
                .setValue(Uid).addOnCompleteListener {
                    if (it.isSuccessful) {
                        changeCurrentUsername()
                    } else {
                        showToast(context = context, message = it.exception.toString())
                    }

                }
        }
    }


    // Change current username in Node_users in FB
    private fun changeCurrentUsername() {
        viewModelScope.launch {
            Ref_Database_Root.child(NODE_USER).child(Uid).child(CHILD_USERNAME)
                .setValue(username.value.lowercase(Locale.getDefault()))
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(
                            message = context.getString(R.string.succesful_change_username_toast_message),
                            context = context
                        )
                        removeOldUsername()
                    } else {
                        showToast(message = it.exception.toString(), context = context)
                    }
                }
        }
    }

    private fun removeOldUsername() {
        Ref_Database_Root.child(NODE_USERNAME).child(User.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    User.username = mUsername
                } else {
                    showToast(context = context, message = it.exception.toString())
                }
            }
    }
}