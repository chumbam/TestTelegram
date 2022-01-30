package ru.isaev.drawerjetpackcompose.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.ui.menu.DrawerDndTopMenu.DrawerAndTopMenu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = applicationContext
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navController = rememberNavController()
        val isAuth = remember { mutableStateOf(false) }
        val mAuth = FirebaseAuth.getInstance()
        setContent {
            MaterialTheme {


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
                    navController = navController,
                    isAuth = isAuth,
                    context = context,
                    mAuth = mAuth
                )
            }
        }
    }
}



