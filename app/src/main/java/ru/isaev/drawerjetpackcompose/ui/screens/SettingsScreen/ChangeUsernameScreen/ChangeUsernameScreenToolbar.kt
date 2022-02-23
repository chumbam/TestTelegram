package ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.ChangeUsernameScreen


import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.*
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel


@Composable
fun ChangeUserameScreenTollbar(viewModel: SettingViewModel, navController: NavHostController) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },

        actions = {

            IconButton(onClick = {
                if (viewModel.username.value.isEmpty()) showToast(
                    message = "Поле не может быть пустым",
                    context = context
                )
                else {
                    Ref_Database_Root.child(NODE_USERNAME)
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.hasChild(viewModel.username.value)) {
                                    showToast(
                                        context = context,
                                        message = context.getString(R.string.ChangeUsernameScreenToolbar_usernameisbusy_toast_text)
                                    )
                                } else {
                                    viewModel.mUsername = viewModel.username.value
                                    viewModel.changeUsername()
                                    navController.navigateUp()
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {

                            }
                        })

                }
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "")
            }
        },
        backgroundColor = Colors.KotogramMainColor,
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier.height(58.dp)

    )
}