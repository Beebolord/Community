package com.forest.community.android.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ticket.ui.theme.DarkOrange
import com.example.ticket.ui.theme.LightOrange
import com.forest.community.android.NavRoute
import com.forest.community.android.R
import com.forest.community.android.ui.viewmodels.LoginScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Intro(navController: NavHostController) {
    var phoneNumber = remember{mutableStateOf("")}
    var regionIndex = remember{mutableStateOf("")}
    var mExpanded by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current
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
                    value = regionIndex.value,
                    onValueChange = {regionIndex.value = it},
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        textColor = Color.Black
                    ),
                    placeholder = {Text("+", color = Color.Black)},
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(),
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {keyboardController?.hide();mExpanded = true}
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(12.dp), clip = true)

                )
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.Warning),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
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
                        navController.navigate("verification/+${regionIndex.value}${phoneNumber.value}")
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = DarkOrange,
                        backgroundColor = DarkOrange
                    ),
                modifier = Modifier
                    .width(240.dp)
                    .padding(vertical = 8.dp)

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
    AnimatedVisibility(
        visible = mExpanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
       CodeGrabber(phoneNumber = "${regionIndex}${phoneNumber}")
    }
    }
@Composable
fun CodeGrabber(phoneNumber:String) {
    val viewModel : LoginScreenViewModel = viewModel()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.OTP),
                style  = Typography.body2
            )
            Text(
                text = phoneNumber,
                style = Typography.body2
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround) {
                DigitBox(ImeAction.Next)
                DigitBox(ImeAction.Next)
                DigitBox(ImeAction.Next)
                DigitBox(ImeAction.Next)
                DigitBox(ImeAction.Done)

            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DigitBox(action : ImeAction) {
    val keyboardController = LocalSoftwareKeyboardController.current
   var digit by remember{mutableStateOf("")}
    Card(
       modifier = Modifier
           .width(25.dp)
           .height(32.dp)
           .border(width = 0.2.dp, color = Color.Black, shape = RoundedCornerShape(2.dp))
           .shadow(7.dp, shape = RoundedCornerShape(2.dp)),
        backgroundColor = Color.White
   ) {
       Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
           TextField(
               value = digit,
               onValueChange = {digit = it},
               textStyle = Typography.h5,
               keyboardActions = KeyboardActions(
                   onDone = { keyboardController?.hide() }
               ),
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,imeAction = action))
       }
   }
}
@Composable
@Preview
fun IntroPreview() {
    //Intro(navController = NavHostController(LocalContext.current))
    CodeGrabber(phoneNumber = "4189305435")
}