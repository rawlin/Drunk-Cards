package com.example.drunkcards.models

data class TaskComment (
        val taskId:String,
        val commentedBy:String,
        val commenterId:String,
        val commentText:String,
        val commentId:String,
        val commentedDate:String="Today"
)