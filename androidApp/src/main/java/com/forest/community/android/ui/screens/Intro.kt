package com.forest.community.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ticket.ui.theme.DarkOrange
import com.example.ticket.ui.theme.LightOrange
import com.forest.community.android.NavRoute
import com.forest.community.android.R

@Composable
fun Intro(navController: NavHostController) {
    var phoneNumber = remember{mutableStateOf("")}
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.height(50.dp))
        Column() {
            Text(
                text = stringResource(id= R.string.IntroTitle),
                style = MaterialTheme.typography.h5,
                fontFamily = fonts,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            )
            Row(Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                TextField(
                    value = "+91",
                    onValueChange = {},
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        textColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .width(60.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(12.dp), clip = true)
                )
                Spacer(Modifier.width(10.dp))
                TextField(
                    value = phoneNumber.value,
                    onValueChange = { phoneNumber.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        textColor = Color.Black
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(12.dp), clip = true)
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.Warning),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp)
            )
            Text(
                text = stringResource(id=R.string.TM),
                style = MaterialTheme.typography.body1,
                color = LightOrange,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth()
            )
            Button(
                    onClick = {
                        navController.navigate(NavRoute.Identification.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = DarkOrange,
                        backgroundColor = DarkOrange
                    ),
                modifier = Modifier.width(240.dp).padding(vertical = 8.dp)

                ) {
                    Text(
                        text = stringResource(R.string.Proceed),
                        color = Color.White,
                    style = MaterialTheme.typography.h5)
                }
                Row(modifier = Modifier
                    .shadow(elevation = 0.dp)
                    .border(width = 0.dp, color = Color.White)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(id = R.string.NotRegistered),
                        style = MaterialTheme.typography.body1,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = stringResource(id = R.string.SignUp),
                        style = MaterialTheme.typography.body1,
                        color = LightOrange,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }

@Composable
@Preview
fun IntroPreview() {
    Intro(navController = NavHostController(LocalContext.current))
}