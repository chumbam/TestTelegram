package ru.isaev.drawerjetpackcompose.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.helpers.Auth
import ru.isaev.drawerjetpackcompose.helpers.getActivity
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.DrawerAndTopMenu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = applicationContext
        getActivity = this
        Auth = FirebaseAuth.getInstance()
        setContent {
            MaterialTheme {
                val scope = rememberCoroutineScope()
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                val navController = rememberNavController()

                DrawerAndTopMenu(
                    scaffoldState = scaffoldState,
                    drawerButtonClick = {
                        scope.launch {
                            if (scaffoldState.drawerState.isClosed) {
                                scaffoldState.drawerState.open()
                            } else scaffoldState.drawerState.close()
                        }
                    },
                    scope = scope,
                    navController = navController
                )
            }
        }
    }
}



