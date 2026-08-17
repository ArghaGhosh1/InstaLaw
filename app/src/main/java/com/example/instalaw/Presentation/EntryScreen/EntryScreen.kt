package com.example.instalaw.Presentation.EntryScreen

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instalaw.Navigation.Screen
import com.example.instalaw.R


@Composable()
fun EntryScreen(navController : NavHostController) {


    Column(
        modifier = Modifier
            .background(color = colorResource(R.color.white))
            .verticalScroll(
                rememberScrollState()
            )
            .fillMaxSize()
    ) {

        Box(contentAlignment = Alignment.Center) {

            Image(
                painter = painterResource(R.drawable.entry_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.instalaw_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.Crop
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "Instant Legal Advice at Your.",
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Fingertips.",
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "Access reliable legal suggestions in seconds with our AI-powered platform. Fast, accurate, and completely private",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(25.dp))

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = colorResource(R.color.white)
                )
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {


                    Card(
                        modifier = Modifier.size(70.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.TransparentBlue))
                    ) {

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.thunder),
                                contentDescription = null,
                                modifier = Modifier,
                                tint = colorResource(R.color.purple_700)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))


                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text("Immediate Clarity", fontWeight = FontWeight.Bold, fontSize = 20.sp)

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            "24/7 access to legal insights without the wait or office hours.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )

                    }

                }


            }


            Spacer(modifier = Modifier.height(25.dp))

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = colorResource(R.color.white)
                )
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {

                    Card(
                        modifier = Modifier.size(70.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.TransparentBlue))
                    ) {

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.shild),
                                contentDescription = null,
                                modifier = Modifier,
                                tint = colorResource(R.color.purple_700)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.width(16.dp))


                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text("Bank-Grade Privacy", fontWeight = FontWeight.Bold, fontSize = 20.sp)

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            "Your sensitive queries are fully encrypted and remains anonymous.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )

                    }

                }


            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.NewUserRegistration.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.Button_Blue)
                )

            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Get Started", fontSize = 20.sp)

                    Spacer(modifier = Modifier.width(5.dp))

                    Icon(
                        painter = painterResource(R.drawable.outline_arrow_right_alt_24),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                    )
                }

            }

            Spacer(modifier = Modifier.height(14.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Already have an account? ")


                TextButton(onClick = {
                    navController.navigate(Screen.AlreadyHaveAnAccount.route)
                }, contentPadding = PaddingValues(0.dp)) {

                    Text("Sign In")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Trusted by 50,000+ professionals", color = Color.Gray)

                Spacer(modifier = Modifier.height(25.dp))

                Row() {
                    Text(
                        "LEXIS",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(25.dp))


                    Text(
                        "VERITAS",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(25.dp))


                    Text(
                        "JURIS",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontSize = 25.sp
                    )

                }

            }
        }


    }


}