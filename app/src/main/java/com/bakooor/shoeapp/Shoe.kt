package com.bakooor.shoeapp

import java.io.Serializable

data class Shoe(
    val name:String,
    val company:String,
    val size:Int,
    val description:String
): Serializable
