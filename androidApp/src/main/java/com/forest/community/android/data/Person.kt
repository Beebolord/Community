package com.forest.community.android.data

import android.media.Image

data class Person(
    val firstName : String = "Ismael",
    var secondName: String = "Forest",
    val picture : Image? = null,
    val address : String,
    val age : Int,
    val state: String = "",
    val parliament: String = "",
    val assembly: String= "",
    val booth : String = ""
)
val PersonMockData = listOf(Person(
    firstName = "DEVINDER",
    secondName = "KUMAR",
    address = "1B",
    age = 58,
),Person(
    firstName = "DEVINDER",
    secondName = "KUMAR",
    address = "1B",
    age = 58,
)
)