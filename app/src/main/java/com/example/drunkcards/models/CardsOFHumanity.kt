package com.example.drunkcards.models

/**
 * 6 seconds timer for each card
 */
data class CardsOFHumanity (
    val cardId:String,
    val question:String,
    val options:List<String>,
    var userId:String="",
    var userSelectedOption: Int=-1,
    val timer:Int=6
)