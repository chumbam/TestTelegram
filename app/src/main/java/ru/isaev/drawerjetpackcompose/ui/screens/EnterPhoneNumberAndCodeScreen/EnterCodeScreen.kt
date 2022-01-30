package ru.isaev.drawerjetpackcompose.ui.screens.EnterPhoneNumberAndCodeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.isaev.drawerjetpackcompose.R
import ru.isaev.drawerjetpackcompose.helpers.Colors

@Composable
fun EnterCodeScreen(context: Context, navController: NavHostController) {
    val image = painterResource(R.drawable.register_image)
    val code = remember { mutableStateOf("") }
    val maxChar = 6

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(top = 16.dp)) {
            Image(image, contentDescription = "")
        }
        Text(text = "Введите код", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold)
        Text(
            text = "Мы отправили смс с кодом проверки на ваш телефон",
            fontSize = 10.sp,
            style = TextStyle(color = Colors.descriptionTextColor),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = code.value,
            onValueChange = { if(it.length <= maxChar) code.value = it
                               if (code.value.length == 6){
                                   Toast.makeText(context,"ok", Toast.LENGTH_LONG).show()
                                   navController.navigate("1")
                               }
                            },
            placeholder = {Text(text = "_ _ _ _ _ _")},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.25f),
            )

    }
}