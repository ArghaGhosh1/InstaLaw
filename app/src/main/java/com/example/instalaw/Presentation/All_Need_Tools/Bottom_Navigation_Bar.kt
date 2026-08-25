package com.example.whatsappclone.presentation.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.instalaw.JwtManager
import com.example.instalaw.Navigation.Screen
import com.example.instalaw.R


@Composable
fun bottomNavigation(
    navController: NavHostController
) {

    var selectedItem by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    BottomAppBar(tonalElevation = 12.dp, containerColor = Color.White) {

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            selectedItem = 0

                            if (JwtManager.isLoggedIn(context)) {

                                // User is logged in
                                navController.navigate(
                                    Screen.HomeScreen.route
                                )

                            } else {

                                // User is NOT logged in
                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }

                        },
                    tint = if (selectedItem == 0) Color.Blue else Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text("Home", fontWeight = FontWeight.Bold)
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.cases),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            selectedItem = 1


                        },
                    tint = if (selectedItem == 1) Color.Blue else Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))


                Text("Cases", fontWeight = FontWeight.Bold)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.lawyers),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            selectedItem = 2

                            if (JwtManager.isLoggedIn(context)) {

                                // User is logged in
                                navController.navigate(
                                    Screen.LawyersScreen.route
                                )

                            } else {

                                // User is NOT logged in
                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }

                        },
                    tint = if (selectedItem == 2) Color.Blue else Color.Black

                )

                Spacer(modifier = Modifier.height(2.dp))


                Text("Lawyers", fontWeight = FontWeight.Bold)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.account),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            selectedItem = 3

                        },
                    tint = if (selectedItem == 3) Color.Blue else Color.Black

                )

                Spacer(modifier = Modifier.height(2.dp))

                Text("Profile", fontWeight = FontWeight.Bold)
            }
        }
    }

}