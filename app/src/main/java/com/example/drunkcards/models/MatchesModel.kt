package com.example.drunkcards.models

data class MatchesModel (
    var matchId:String,
    val userOneId:String,
    val userTwoId:String,
    val userOneName:String,
    val userTwoName:String
)