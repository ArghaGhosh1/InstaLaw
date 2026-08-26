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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instalaw.JwtManager
import com.example.instalaw.Navigation.Screen
import com.example.instalaw.R


@Composable
fun bottomNavigation(
    navController: NavHostController
) {

    // Get the currently displayed screen
    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route
    val context = LocalContext.current

    BottomAppBar(tonalElevation = 12.dp, containerColor = Color.White) {

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (JwtManager.isLoggedIn(
                                    navController.context
                                )
                            ) {

                                navController.navigate(
                                    Screen.HomeScreen.route
                                ) {

                                    launchSingleTop = true
                                    popUpTo(
                                        Screen.HomeScreen.route
                                    ) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }

                            } else {

                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }

                        },
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text("Home", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.cases),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (JwtManager.isLoggedIn(
                                    navController.context
                                )
                            ) {

                                navController.navigate(
                                    Screen.CasesScreen.route
                                ) {

                                    launchSingleTop = true
                                    popUpTo(
                                        Screen.HomeScreen.route
                                    ) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }

                            } else {

                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }

                        },
                )

                Spacer(modifier = Modifier.height(2.dp))


                Text("Cases", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.lawyers),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (JwtManager.isLoggedIn(
                                    navController.context
                                )
                            ) {

                                navController.navigate(
                                    Screen.LawyersScreen.route
                                ) {

                                    launchSingleTop = true
                                    popUpTo(
                                        Screen.HomeScreen.route
                                    ) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }

                            } else {

                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }

                        },

                )

                Spacer(modifier = Modifier.height(2.dp))


                Text("Lawyers", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {

                Icon(
                    painter = painterResource(R.drawable.account),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (JwtManager.isLoggedIn(
                                    navController.context
                                )
                            ) {

                                navController.navigate(
                                    Screen.HomeScreen.route
                                ) {

                                    launchSingleTop = true
                                    popUpTo(
                                        Screen.HomeScreen.route
                                    ) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }

                            } else {

                                navController.navigate(
                                    Screen.AlreadyHaveAnAccount.route
                                )
                            }
                        },

                )

                Spacer(modifier = Modifier.height(2.dp))

                Text("Profile", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }
    }

}