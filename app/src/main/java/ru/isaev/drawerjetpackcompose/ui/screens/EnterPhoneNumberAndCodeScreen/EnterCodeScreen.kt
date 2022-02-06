package ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.*

@Composable
fun EnterCodeScreen(navController: NavHostController) {
    val image = painterResource(R.drawable.register_image)
    val code = remember { mutableStateOf("") }
    val maxChar = 6
    val scope = rememberCoroutineScope()
    val context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(top = 16.dp)) {
            Image(image, contentDescription = "")
        }
        Text(
            text = stringResource(R.string.ECS_enter_code_text),
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.ECS_message_about_sending_text),
            fontSize = 10.sp,
            style = TextStyle(color = Colors.descriptionTextColor),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = code.value,
            onValueChange = {
                if (it.length <= maxChar) code.value = it
                if (it.length == maxChar) {
                    val credential = PhoneAuthProvider.getCredential(Sender.idString, code.value)
                    Auth.signInWithCredential(credential).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val uId = Auth.currentUser?.uid.toString()
                            val dataMap = mutableMapOf<String, Any>()
                            scope.launch {
                                dataMap[CHILD_ID] = uId
                                dataMap[CHILD_PHONE] = Sender.phoneNumber
                                dataMap[CHILD_USERNAME] = uId

                                Ref_Database_Root.child(NODE_USER).child(uId)
                                    .updateChildren(dataMap).addOnCompleteListener { taskTwo ->
                                        if (taskTwo.isSuccessful) {
                                            showToast(
                                                context = context,
                                                message = context.getString(R.string.ECS_greeting)
                                            )
                                        } else showToast(
                                            context = context,
                                            message = taskTwo.exception?.message.toString()
                                        )


                                    }
                            }

                            navController.navigate(NavDrawerItem.Chats.route)

                        } else showToast(
                            context = context,
                            message = task.exception?.message.toString()
                        )

                    }


                }
            },
            placeholder = { Text(text = stringResource(R.string.ECS_placeholder_text)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.27f),
        )

    }
}