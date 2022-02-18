package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.helpers.*

class SettingViewModel(application: Application) : AndroidViewModel(application) {

    //this is an alternative to remember{mutableStateOf} which is used only in composable functions. This method is used in view Models
    var _name = mutableStateOf("")
    var name: State<String> = _name
    var _surname = mutableStateOf("")
    var surname: State<String> = _surname

    var fullname = ""

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
}