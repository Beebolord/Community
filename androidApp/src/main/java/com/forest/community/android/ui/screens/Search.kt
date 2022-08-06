package com.forest.community.android.ui.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ticket.ui.theme.LightOrange
import com.forest.community.android.R
import com.forest.community.android.data.Person
import com.forest.community.android.data.PersonMockData
import com.forest.community.android.ui.fonts

@Composable
fun Search(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally ) {
        Spacer(modifier = Modifier.height(30.dp))
        SearchView(state = textState, modifier = Modifier.padding(horizontal = 22.dp))
        ResultItem(person = PersonMockData)
    }
}
@Composable
fun SearchView(state: MutableState<TextFieldValue>, modifier : Modifier ) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = {Text(text= stringResource(id = R.string.Search), fontSize =18.sp, fontFamily = fonts)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .shadow(5.dp, shape = RoundedCornerShape(30.dp)),
        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp, fontFamily = fonts, fontWeight = FontWeight.SemiBold),
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(30.dp), // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = LightOrange,
            leadingIconColor = Color.White,
            trailingIconColor = Color.Gray,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ResultItem(person : Person) {
    Card() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Image(ImageVector.vectorResource(id = R.drawable.ic_baseline_person_outline_24),
                    "person",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(15.dp))
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "${(person.firstName).uppercase(java.util.Locale.ROOT)} ${
                        (person.secondName).uppercase(java.util.Locale.ROOT)
                    }",
                        style = MaterialTheme.typography.subtitle1,
                        fontFamily = fonts,
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "Address: ${person.address}",
                        style = MaterialTheme.typography.body2,
                        fontFamily = fonts)
                }
            }
            Column(verticalArrangement =  Arrangement.Bottom) {
                Text(text = "Age: ${person.age}", style = MaterialTheme.typography.body2, fontFamily = fonts)
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
   ResultItem(person = PersonMockData)
}
