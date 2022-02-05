package ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.*
import ru.isaev.drawerjetpackcompose.helpers.Colors
import java.util.concurrent.TimeUnit


@Composable
fun EnterPhoneNumberScreen(
    navController: NavHostController
) {
    val phoneNumber = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val maxChar = 14
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val context = LocalContext.current

    val mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                Sender.idString = id
                Sender.mToken = token
                navController.navigate("11")
            }

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(context = context,message = context.getString(R.string.EPNS_greeting))

                    } else showToast(context = context ,message = it.exception?.message.toString())

                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(context = context, message = p0.message.toString())
            }
        }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                // remember
                onClick = {
                        if (phoneNumber.value.isNotEmpty() && phoneNumber.value.length >= 12) {
                            val options: PhoneAuthOptions = PhoneAuthOptions
                                .newBuilder(Auth)
                                .setPhoneNumber(phoneNumber.value)
                                .setTimeout(60, TimeUnit.SECONDS)
                                .setActivity(getActivity)
                                .setCallbacks(mCallback)
                                .build()
                            Sender.phoneNumber = phoneNumber.value
                            PhoneAuthProvider.verifyPhoneNumber(options)
                        } else showToast(context = context, message = context.getString(R.string.EPNS_invalid_input_format_password))

                },
                shape = CircleShape,
                backgroundColor = Colors.topBarColor,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.ArrowForward, "")
            }

        }
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                OutlinedTextField(
                    value = phoneNumber.value,
                    onValueChange = { if (it.length < maxChar) phoneNumber.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                    placeholder = { Text(text = stringResource(R.string.ECNS_placeholder_text)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Colors.topBarColor,
                        unfocusedBorderColor = Colors.topBarColor
                    )

                )

            }


        }
    }

}






