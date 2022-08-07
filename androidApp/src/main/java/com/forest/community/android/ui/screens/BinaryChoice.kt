package com.forest.community.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ticket.ui.theme.DarkOrange
import com.example.ticket.ui.theme.Whiteish
import com.forest.community.android.NavRoute
import com.forest.community.android.R
import com.forest.community.android.ui.Typography
import com.forest.community.android.ui.fonts
import com.forest.community.android.ui.util.Next

@Composable
fun BinaryChoice(navController: NavController) {
    var backgroundColor1 by remember{mutableStateOf(Color.White)}

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.height(250.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            ImageCard(navController, R.drawable.president1, R.string.President)
            ImageCard(navController, R.drawable.community, R.string.Member)
        }
        Next(navController, route="verification/+14189305435")
    }
}

@Composable
fun ImageCard(navController : NavController, id: Int, label: Int) {
    val image: Painter = painterResource(id = id)
    var backgroundColor by remember{mutableStateOf(Color.White)}
    Card(
        backgroundColor = backgroundColor,
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .clickable{backgroundColor = if(backgroundColor == Color.White) DarkOrange else Color.White},
        shape = RoundedCornerShape(15.dp),
    elevation = 6.dp) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = image,contentDescription = "", modifier = Modifier
                .width(130.dp)
                .height(130.dp)
                .padding(12.dp),
                contentScale = ContentScale.Inside,
            alignment = Alignment.Center)
            Text(
                text = stringResource(label),
                style = Typography.h5,
                color = if(backgroundColor == Color.White) Color.Black else Whiteish,
                modifier = Modifier.fillMaxWidth().padding(bottom=15.dp),
                textAlign  = TextAlign.Center,
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}