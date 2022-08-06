package com.forest.community.android.data

import android.media.Image

data class Person(
    val firstName : String = "Ismael",
    var secondName: String = "Forest",
    val picture : Image? = null,
    val address : String,
    val age : Int,
)
val PersonMockData = Person(
    firstName = "DEVINDER",
    secondName = "KUMAR",
    address = "1B",
    age = 58,
)