package com.example.instalaw.NewUserRegistration

import android.util.Size
import android.widget.Space
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
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalaw.R


@Preview(
    showSystemUi = true,
    device = "id:pixel_9_pro"
)
@Composable()
fun NewUserRegistration() {

    var full_name by remember() {

        mutableStateOf("")

    }

    var email by remember() {

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
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(R.drawable.instalaw_logo),
            contentDescription = null,
            modifier = Modifier.size(70.dp),
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text("InstaLaw", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Create Your Account", fontSize = 34.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(10.dp))


        Text(
            "Join 50,000+ legal professionals today.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))


        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Column(modifier = Modifier.padding(20.dp)) {


                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(R.drawable.google_logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                        )

                        Text("Continue with Google", fontSize = 15.sp, color = Color.Black)
                    }


                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        colorResource(R.color.black)
                    )
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(R.drawable.apple_logo),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                        )

                        Text("Continue with Apple", fontSize = 15.sp, color = Color.White)
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

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
                        "OR REGISTER WITH EMAIL",
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

                Spacer(modifier = Modifier.height(15.dp))

                Text("Full Name", color = Color.Gray, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(5.dp))


                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = full_name,
                    onValueChange = { full_name = it },
                    placeholder = {

                        Text("Argha Ghosh", color = Color.Gray)
                    }
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text("Email Address", color = Color.Gray, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("xyz@gmail.com", color = Color.Gray) }
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text("Passeord", color = Color.Gray, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = full_name,
                    onValueChange = { full_name = it },
                    placeholder = { Text("Min. 8 Charecters", color = Color.Gray) }
                )


                Spacer(modifier = Modifier.height(15.dp))



                Row(verticalAlignment = Alignment.CenterVertically) {

                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )

                    Column() {
                        Row() {

                            Text(
                                "I agree to the",
                                fontSize = 15.sp,
                                color = Color.Gray
                            )

                            Text(
                                " Terms of Service",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.Blue
                            )

                            Text(
                                " and",
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        }



                        Text(
                            "Privacy Policy",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = Color.Blue
                        )
                    }


                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.Button_Blue)
                    )

                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Create Account", fontSize = 23.sp, fontWeight = FontWeight.Bold)

                    }

                }



            }

        }

        //If you Already have account.click here

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Already have an account? ")


            TextButton(onClick = {}, contentPadding = PaddingValues(0.dp)) {

                Text("Sign In")
            }
        }

    }
}