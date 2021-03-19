package com.example.drunkcards.models

data class Comment(
    val id: Int,
    val image: Int? = null,
    val user: String,
    val comment: String
)
