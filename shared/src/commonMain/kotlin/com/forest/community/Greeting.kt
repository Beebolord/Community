package com.forest.community

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}