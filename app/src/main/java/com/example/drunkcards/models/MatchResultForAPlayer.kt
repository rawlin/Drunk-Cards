package com.example.drunkcards.models

/**
 * Match id is same as game id
 */
data class MatchResultForAPlayer (
    val userId:String,
    val matchId:String,
    val username:String,
    val userPoints:Int,
    val userRewards:Int=0,
    val matchesPlayed:Int=0
)