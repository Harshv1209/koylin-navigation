package com.harsh.baiscapp.main

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable fun SignupPage(navController: NavController) {
    Column (
//        verticalArrangement = Arrangement.Center
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = Color(0xFF0F1C27))
    ) {

        data class UserCredentials(val name:String, val phoneNumber: String, val password: String)

        val userCredentialsList = listOf(
            UserCredentials("Hitika","123", "hitika"),
            UserCredentials("Harsh","456", "harsh"),
            UserCredentials("Aman","789", "aman"),
            UserCredentials("Deepak","1011", "deepak"),
        )

        @Composable
        fun SignupPage() {
            var phonenumber by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var name by rememberSaveable { mutableStateOf("") }

            val performSignup: (String, String,String) -> Boolean = { enteredName,enteredPhoneNumber, enteredPassword ->
                userCredentialsList.any { it.name == enteredName && it.phoneNumber == enteredPhoneNumber && it.password == enteredPassword }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "SignUp",
                    color = Color(0xFFADFF2F),
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    letterSpacing = 0.8.sp,
                )
                Spacer(modifier = Modifier.height(34.dp))

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    tint = Color(0xFFADFF2F),
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color(0xFFADFF2F),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFADFF2F),
                        containerColor = Color.Black
                    ),
                )
                TextField(
                    value = phonenumber,
                    onValueChange = { phonenumber = it },
                    placeholder = { Text("Phone number") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color(0xFFADFF2F),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFADFF2F),
                        containerColor = Color.Black
                    ),
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color(0xFFADFF2F),
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color(0xFFADFF2F),
                        containerColor = Color.Black
                    ),

                    placeholder = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(26.dp))

                Button(
                    onClick = {
                        if (performSignup(name,phonenumber, password)) {
                            val route = "$Routes.OTP?name=$name&phoneNumber=$phonenumber&password=$password"
                            navController.navigate(route)
                        }
                        else{
                            println("Invalid Input")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(Color(0xFFADFF2F)),
                    shape = RectangleShape,

                    ) {
                    Text(
                        text = "Signup",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black,

                        )
                }
            }
        }

        SignupPage()
    }
}