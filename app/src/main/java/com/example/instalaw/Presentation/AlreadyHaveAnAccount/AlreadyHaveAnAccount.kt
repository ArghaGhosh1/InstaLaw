package com.example.instalaw.Presentation.AlreadyHaveAnAccount

import LoginRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.instalaw.Navigation.Screen
import com.example.instalaw.R
import com.example.instalaw.RetrofitInstance

@Composable

fun AlreadyHaveAnAccount(navController : NavHostController, viewModel: LoginViewModel = viewModel()) {

    val context = LocalContext.current
    var username by remember() {

        mutableStateOf("")
    }

    var password by remember()
    {
        mutableStateOf("")
    }

    var checked by remember() {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.entry_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop

        )

    }

    Column(
        modifier = Modifier
            .padding(start = 20.dp,top = 50.dp,end = 20.dp, bottom = 20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(R.drawable.instalaw_logo),
            contentDescription = null,
            modifier = Modifier.size(70.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    "Welcome Back",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Enter your credentials to access your",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(5.dp))


                Text(
                    "legal dashboard.",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    OutlinedButton(
                        modifier = Modifier.background(color = Color.White),
                        onClick = {},
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.google_logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                        )

                        Text(
                            "Google",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }

                    OutlinedButton(
                        modifier = Modifier.background(color = Color.White),
                        onClick = {},
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.apple_logo2),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                        )

                        Text(
                            "Apple",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // OR CONTINUE WITH EMAIL

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = Color.LightGray
                    )
                    Spacer(modifier = Modifier.width(7.dp))

                    Text(
                        "OR CONTINUE WITH EMAIL",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.width(7.dp))

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = Color.LightGray
                    )
                }

                Column() {

                    Spacer(modifier = Modifier.height(15.dp))

                    Text("Email Address", color = Color.Gray, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = username,
                        onValueChange = { username = it },
                        placeholder = { Text("xyz@gmail.com", color = Color.Gray) }
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text("Passeord", color = Color.Gray, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("Min. 8 Charecters", color = Color.Gray) }
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )

                    Text("Remember me for 30 day", fontSize = 14.sp, color = Color.DarkGray)

                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {

                        viewModel.login(
                            context = context,
                            username = username,
                            password = password
                        ) {

                            // Only executed when login is successful
                            navController.navigate(Screen.HomeScreen.route) {
                                popUpTo(Screen.AlreadyHaveAnAccount.route) {
                                    inclusive = true
                                }
                            }
                        }
                    },
                    enabled = !viewModel.isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.Button_Blue)
                    )
                ) {

                    Text(
                        text = if (viewModel.isLoading)
                            "Signing In..."
                        else
                            "Sign In",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                if (viewModel.errorMessage.isNotEmpty()) {

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = viewModel.errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        //If you dont have account.click here

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Don't have an account? ",fontSize = 15.sp)


            TextButton(onClick = {
                navController.navigate(Screen.NewUserRegistration.route)
            }, contentPadding = PaddingValues(0.dp)) {

                Text("Sign Up", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Row(horizontalArrangement = Arrangement.SpaceEvenly){

            Row(verticalAlignment = Alignment.CenterVertically){

                Image(
                    painter = painterResource(R.drawable.encryption),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                )

                Text("END-TO-END ENCRYPTED", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.width(40.dp))


            Row(verticalAlignment = Alignment.CenterVertically){

                Image(
                    painter = painterResource(R.drawable.shild_without_tick),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                )

                Text("GDPR COMPLIANT", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }


        }


    }
}