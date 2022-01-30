package ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import ru.isaev.drawerjetpackcompose.activities.MainActivity
import ru.isaev.drawerjetpackcompose.helpers.Colors
import ru.isaev.drawerjetpackcompose.helpers.showToast
import java.util.concurrent.TimeUnit


@Composable
fun AppCompatActivity.EnterPhoneScreenNumber(
    navController: NavHostController,
    context: Context,
    mAuth: FirebaseAuth
) {
    val phoneNumber = remember { mutableStateOf("") }
    val maxChar = 14
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeAutoRetrievalTimeOut(p0: String) {
                super.onCodeAutoRetrievalTimeOut(p0)
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                mAuth
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
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
                            .newBuilder(mAuth)
                            .setTimeout(60, TimeUnit.SECONDS)
                            .setActivity(MainActivity::class.java)
                            .setCallbacks(mCallback)
                            .
//                        navController.navigate("11")
                    } else {
                        Toast.makeText(context, "Неверный формат ввода", Toast.LENGTH_SHORT).show()
                    }
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
                    placeholder = { Text(text = "+7 ___ ___ __ __") },
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

    fun authUser() {


    }

}






