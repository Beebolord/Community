package com.forest.community.android

sealed class NavRoute(val route: String) {
    object Intro : NavRoute("intro")
    object Identification : NavRoute("Identification")
    object Search: NavRoute("Search")
    object BinaryChoice: NavRoute("BinaryChoice")
    object Verification: NavRoute("Verification")
    object PhotoId: NavRoute("PhotoId")
}
