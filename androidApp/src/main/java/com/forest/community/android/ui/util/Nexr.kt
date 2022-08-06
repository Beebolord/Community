package com.forest.community.android.ui.util

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ticket.ui.theme.DarkOrange
import com.example.ticket.ui.theme.Whiteish
import com.forest.community.android.NavRoute
import com.forest.community.android.R

@Composable
fun Next(navController : NavController, route:String) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                navController.navigate(route)
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = DarkOrange,
                backgroundColor = DarkOrange
            ),
            modifier = Modifier
                .width(240.dp)
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.Next),
                color = Whiteish,
                style = MaterialTheme.typography.h5)
        }
    }
}