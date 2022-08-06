package com.forest.community.android.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.ticket.ui.theme.DarkOrange
import com.example.ticket.ui.theme.LightPink
import com.forest.community.android.NavRoute
import com.forest.community.android.R
import com.forest.community.android.ui.Typography
import com.forest.community.android.ui.fonts
import com.forest.community.android.ui.util.Next
import com.forest.community.android.ui.viewmodels.IdentificationViewmodel

@Composable
fun Identification(navController: NavController) {
    val viewmodel = IdentificationViewmodel()
    var mSelectedText by remember { mutableStateOf("") }
    var stateText by remember { mutableStateOf("") }
    var parliamentSelectedText by remember { mutableStateOf("") }
    var assemblyText by remember { mutableStateOf("") }
    var boothText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    var mExpanded by remember { mutableStateOf(false) }
    var list by remember{mutableStateOf(listOf(""))}
    var id by remember{mutableStateOf(0)}
    var isExpanded by remember{mutableStateOf(false)}
    var currentExpandedList by remember{mutableStateOf(PlaceHolder(
        id = 0,
        data = listOf(""),
        isExpanded = false
    ))}
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(20.dp)) {
            // Create an Outlined Text Field
            // with icon and not expanded
            Text(
                text = stringResource(R.string.State),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts
            )
            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                value = stateText,
                onValueChange = { stateText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                textStyle = Typography.h5.plus(TextStyle(fontWeight= FontWeight.W400)),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                label = {Text(text = stringResource(R.string.State), style = Typography.h5)},
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable {
                            mExpanded = !mExpanded
                            list = viewmodel.stateList
                            id = R.string.State
                        }
                    )}
            )
        }
        //Parliament
        Column(Modifier.padding(20.dp)) {
            // Create an Outlined Text Field
            // with icon and not expanded
            Text(
                text = stringResource(R.string.Parliament),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts
            )
            Spacer(Modifier.height(4.dp))

            OutlinedTextField(
                value = parliamentSelectedText,
                onValueChange = { parliamentSelectedText = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                textStyle = Typography.h5.plus(TextStyle(fontWeight= FontWeight.W400)),

                label = {Text(text = stringResource(R.string.Parliament), style = Typography.h5)},
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable {
                            mExpanded = !mExpanded
                            list = viewmodel.parliamentList
                            id = R.string.Parliament
                        }
                    )}
            )
        }
        //Assembly
        Column(Modifier.padding(20.dp)) {
            // Create an Outlined Text Field
            // with icon and not expanded
            Text(
                text = stringResource(R.string.Assembly),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts
            )
            Spacer(Modifier.height(4.dp))

            OutlinedTextField(
                value = assemblyText,
                onValueChange = {assemblyText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                textStyle = Typography.h5.plus(TextStyle(fontWeight= FontWeight.W400)),
                label = {Text(text = stringResource(R.string.Assembly), style =Typography.h5)},
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable {
                            mExpanded = !mExpanded
                            list = viewmodel.assemblyList
                            id = R.string.Assembly
                        }
                    )}
            )
        }
        //Booth
        Column(Modifier.padding(20.dp)) {
            // Create an Outlined Text Field
            // with icon and not expanded
            Text(
                text = stringResource(R.string.Booth),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts
            )
            Spacer(Modifier.height(4.dp))

            OutlinedTextField(
                value = boothText,
                onValueChange = { boothText= mSelectedText },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                textStyle = Typography.h5.plus(TextStyle(fontWeight= FontWeight.W400)),

                label = {Text(text = stringResource(R.string.Booth), style = Typography.h5)},
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable {
                            mExpanded = !mExpanded
                            list = viewmodel.boothList
                            id = R.string.Booth
                        }
                    )}
            )
        }
    }
    AnimatedVisibility(
        visible = mExpanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.6f)),
        verticalArrangement = Arrangement.Bottom)
    {
        Card(
            backgroundColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            shape = RoundedCornerShape(25.dp)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Select ${stringResource(id)}",modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts,
                    color = Color.Black)
                Divider(Modifier.padding(horizontal = 20.dp))
                LazyColumn {
                    items(list) { data ->
                        DropdownMenuItem(onClick = {
                            when(id) {
                                R.string.State -> stateText= data
                                R.string.Parliament ->parliamentSelectedText = data
                                R.string.Assembly -> assemblyText= data
                                R.string.Booth -> boothText = data
                            }
                            mExpanded = false
                        }) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp)) {
                                Image(ImageVector.vectorResource(id = R.drawable.ic_baseline_location_on_24),
                                    "Night",
                                    colorFilter = ColorFilter.tint(Color.Black))

                                Text(text = data, color = Color.Gray, style = MaterialTheme.typography.h6, fontFamily = fonts
                                )

                            }}
                    }
                }
            }}
    }
    }
   Next(navController,route= NavRoute.Search.route)
}

@Composable
fun DropDownMenus(id : Int) : Boolean{
    // the expanded state of the Text Field
    var BigExpand by remember{ mutableStateOf(false)}
    var mExpanded by remember { mutableStateOf(false) }
    // Create a list of cities
    // Create a string value to store the selected city\
    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    var mSelectedText by remember { mutableStateOf("") }

    Column(Modifier.padding(20.dp)) {
        // Create an Outlined Text Field
        // with icon and not expanded
        Text(
            text = stringResource(id),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            fontFamily = fonts
        )
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text(text = stringResource(id))},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable {mExpanded = !mExpanded }
                )}
        )
    }
    return mExpanded
}
@Composable
fun CardItem(text : String, modifier : Modifier, click: ()->Unit) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            ImageVector.vectorResource(id = R.drawable.ic_baseline_location_on_24),
            "Location",
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(text = text,color =  Color.Gray, style = MaterialTheme.typography.h6, modifier= Modifier.clickable{click})
    }
}
@Composable
@Preview
fun IdentificationPreview() {
    Identification(navController = NavController(LocalContext.current))
}

data class PlaceHolder(
    val id: Int,
    val data: List<String>,
    val isExpanded: Boolean
)